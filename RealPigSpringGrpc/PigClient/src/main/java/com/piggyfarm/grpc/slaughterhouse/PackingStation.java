package com.piggyfarm.grpc.slaughterhouse;

import com.piggyfarm.grpc.model.*;

import java.util.ArrayList;
import java.util.List;

public class PackingStation implements Runnable
{

  private Shop shop;
  private List<Tray> trays;

  //Cycle algorithm
  private List<PigPart> pigPartsList = List.of(PigPart.values());
  private PigPart partToLookfor;
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




  public void recieveTrays(Tray tray)
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

    if (count == pigPartsList.size()){
      count = 0;
    }
  }



  private void addToPackage(Tray tray)
  {
    if (partToLookfor == PigPart.HEAD && headAndBottom.getHead() == null)
    {
      headAndBottom.setHead(tray.getParts().remove(0));

    }
    if (partToLookfor == PigPart.BOTTOM && headAndBottom.getBottom() == null)
    {
      headAndBottom.setBottom(tray.getParts().remove(0));
    }
    if (partToLookfor == PigPart.LEG && ribsAndLegs.getLegs() == null)
    {
      ribsAndLegs.setLegs(tray.getParts().remove(0));
    }
    if (partToLookfor == PigPart.RIBS && ribsAndLegs.getRibs() == null)
    {
      ribsAndLegs.setRibs(tray.getParts().remove(0));
    }

    if (headAndBottom.isFull())
      sendFullPackage(headAndBottom);
    if (ribsAndLegs.isFull())
      sendFullPackage(ribsAndLegs);
  }

  private void sendFullPackage(Product packageToSend)
  {
      //Calculate weight
    double weight = 0;
    for (Part specPart:packageToSend.getParts())
    {
      weight += specPart.getWeight();
    }
    packageToSend.setWeight(weight);

      //Dokumentér på database


      //Send til shop
      shop.deliverProduct(packageToSend);


      //refresh product
    if (packageToSend instanceof HeadAndBottomProduct)
    {
      headAndBottom = new HeadAndBottomProduct();
    }
    if (packageToSend instanceof RibsAndLegsProduct)
    {
      ribsAndLegs = new RibsAndLegsProduct();
    }
  }

}
