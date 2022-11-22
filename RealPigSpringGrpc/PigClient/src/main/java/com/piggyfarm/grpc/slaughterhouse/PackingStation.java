package com.piggyfarm.grpc.slaughterhouse;

import com.piggyfarm.grpc.model.*;
import com.piggyfarm.grpc.service.PigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PackingStation implements Runnable
{
  @Autowired
  private PigService pigService;
  @Autowired
  private Shop shop;
  private List<Tray> trays;

  //Cycle algorithm
  private List<PigPartType> pigPartsList = List.of(PigPartType.values());
  private PigPartType partToLookfor;
  private int count = 0;

  //Packages
  private HeadAndBottomProduct headAndBottom;
  private RibsAndLegsProduct ribsAndLegs;

  public PackingStation(Shop shop)
  {
    this.shop = shop;
    trays = new ArrayList<Tray>();
    run();

    headAndBottom = new HeadAndBottomProduct();
    ribsAndLegs = new RibsAndLegsProduct();
  }

  public void recieveTray(Tray tray)
  {
    this.trays.add(tray);
  }

  @SuppressWarnings("InfiniteLoopStatement") @Override public void run()
  {
    while (true)
    {
      if (!trays.isEmpty())
      {
        cyclePigParts();
        for (Tray specTray : trays)
        {
          if (specTray.getPigPart() == partToLookfor)
          {
            addToPackage(specTray);
          }
        }
      }
    }
  }

  private void cyclePigParts()
  {
    partToLookfor = pigPartsList.get(count);
    System.out.println("Now looking for: " + partToLookfor);

    count++;

    if (count == pigPartsList.size())
    {
      count = 0;
    }
  }

  private void addToPackage(Tray tray)
  {
    if (partToLookfor == PigPartType.HEAD && headAndBottom.getHead() == null)
    {
      headAndBottom.setHead(tray.getParts().remove(0));
    }
    if (partToLookfor == PigPartType.BOTTOM
        && headAndBottom.getBottom() == null)
    {
      headAndBottom.setBottom(tray.getParts().remove(0));
    }
    if (partToLookfor == PigPartType.LEG && ribsAndLegs.getLegs() == null)
    {
      ribsAndLegs.setLegs(tray.getParts().remove(0));
    }
    if (partToLookfor == PigPartType.RIBS && ribsAndLegs.getRibs() == null)
    {
      ribsAndLegs.setRibs(tray.getParts().remove(0));
    }

    if (headAndBottom.isFull())
      sendFullProduct(headAndBottom);
    if (ribsAndLegs.isFull())
      sendFullProduct(ribsAndLegs);
  }

  private void sendFullProduct(Product productToSend)
  {
    //Calculate weight
    double weight = 0;
    for (Part specPart : productToSend.getParts())
    {
      weight += specPart.getWeight();
    }
    productToSend.setWeight(weight);

    //Register to database
    Product registeredProduct = pigService.registerProduct(productToSend);

    //Send til shop
    shop.deliverProduct(registeredProduct);

    //refresh product
    if (productToSend instanceof HeadAndBottomProduct)
    {
      headAndBottom = new HeadAndBottomProduct();
    }
    if (productToSend instanceof RibsAndLegsProduct)
    {
      ribsAndLegs = new RibsAndLegsProduct();
    }
  }

}
