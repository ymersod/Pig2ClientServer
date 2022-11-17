package com.piggyfarm.grpc.slaughterhouse;

import com.piggyfarm.grpc.model.Tray;

import java.util.ArrayList;
import java.util.List;

public class PackingStation implements Runnable
{

  private Shop shop;
  private List<Tray> trayPackages;


  public PackingStation(Shop shop)
  {
    this.shop = shop;
    trayPackages = new ArrayList<Tray>();

  }


  /*
  - Metode modtag en liste af trays
      - Gem dem i en liste feltvariabel



      //Infinite loop
      - Lav feltvariabel trays om til pakker med titel på pakkerne, produkter skal være af en hvis stilart
      - Listen med pakker sendes videre til butik


   */



  public void recieveTrays(List<Tray> trays){
  trayPackages.addAll(trays);
  }

  @Override public void run()
  {

  }
}
