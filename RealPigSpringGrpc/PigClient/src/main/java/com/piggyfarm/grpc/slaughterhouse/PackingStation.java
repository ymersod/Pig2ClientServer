package com.piggyfarm.grpc.slaughterhouse;

import com.domain.Part;
import com.domain.PigPartType;
import com.domain.Product;
import com.domain.Tray;
import com.piggyfarm.grpc.model.*;
import com.piggyfarm.grpc.service.RegisterServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class PackingStation implements Runnable
{
  @Autowired
  private RegisterServiceClient registerServiceClient;
  @Autowired
  private Shop shop;
  private List<Tray> trays;

  //Cycle algorithm
  private List<PigPartType> pigPartsList = Arrays.asList(PigPartType.values());
  private PigPartType partToLookfor;
  private int count = 0;

  //Packages
  private HeadAndBottomProduct headAndBottom;
  private RibsAndLegsProduct ribsAndLegs;

  public PackingStation(Shop shop)
  {
    this.shop = shop;
    trays = new ArrayList<>();
    new Thread(this).start();

    headAndBottom = new HeadAndBottomProduct();
    ribsAndLegs = new RibsAndLegsProduct();
  }

  public synchronized void recieveTray(Tray tray)
  {
    this.trays.add(tray);
  }

  @SuppressWarnings("InfiniteLoopStatement") @Override public void run()
  {
    while (true)
    {
      if (!trays.isEmpty())
      {
        try {
          Thread.sleep(5000);
        } catch (InterruptedException e) {
          throw new RuntimeException(e);
        }
        trySearching();
      }
    }
  }

  private synchronized void trySearching(){
    cyclePigParts();
    for (Tray specTray : trays)
    {
      if (specTray.getPigPart() == partToLookfor)
      {
        addToPackage(specTray);
        break;
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
    if (tray.getParts().isEmpty())
      trays.remove(tray);
    if (headAndBottom.isFull())
      sendFullProduct(headAndBottom);
    if (ribsAndLegs.isFull())
      sendFullProduct(ribsAndLegs);
  }

  private void sendFullProduct(Product productToSend)
  {
    System.out.println(productToSend.getParts().get(0).getType());
    //Calculate weight
    double weight = 0;
    for (Part specPart : productToSend.getParts())
    {
      weight += specPart.getWeight();
    }
    productToSend.setWeight(weight);

    //Register to database
    Product registeredProduct = registerServiceClient.registerProduct(productToSend);

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
