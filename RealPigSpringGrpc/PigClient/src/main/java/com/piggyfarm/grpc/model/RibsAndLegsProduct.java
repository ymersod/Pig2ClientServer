package com.piggyfarm.grpc.model;

import com.domain.Part;
import com.domain.Product;

import java.util.List;

public class RibsAndLegsProduct extends Product
{
  private Part ribs;
  private Part legs;
  private boolean isFull;

  public RibsAndLegsProduct(int id, double weight, List<Part> parts)
  {
    super(id, weight, parts);
  }

  public RibsAndLegsProduct(int id, double weight)
  {
    super(id, weight);
  }

  public RibsAndLegsProduct(int id, double weight, List<Part> parts, Part ribs,
      Part legs)
  {
    super(id, weight, parts);
    this.ribs = ribs;
    this.legs = legs;
  }

  public RibsAndLegsProduct(int id, double weight, Part ribs, Part legs)
  {
    super(id, weight);
    this.ribs = ribs;
    this.legs = legs;
  }

  public RibsAndLegsProduct()
  {
    super();
  }

  public Part getRibs()
  {
    return ribs;
  }

  public void setRibs(Part ribs)
  {
    this.ribs = ribs;
    super.getParts().add(ribs);
    if (getLegs() != null && getRibs() != null)
      isFull = true;
  }

  public Part getLegs()
  {
    return legs;
  }

  public void setLegs(Part legs)
  {
    this.legs = legs;
    super.getParts().add(legs);
    if (getLegs() != null && getRibs() != null)
      isFull = true;
  }

  public boolean isFull()
  {
    return isFull;
  }
}
