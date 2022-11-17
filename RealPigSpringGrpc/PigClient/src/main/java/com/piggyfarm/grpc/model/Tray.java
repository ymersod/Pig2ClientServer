package com.piggyfarm.grpc.model;

import java.util.List;

public class Tray
{
  private int id;
  private List<Part> parts; //update
  private double weight;


  private final PigPart pigPart;

  public Tray(int id, List<Part> parts, double weight, PigPart pigPart)
  {
    this.id = id;
    this.parts = parts;
    this.weight = weight;
    this.pigPart = pigPart;
  }

  public int getId()
  {
    return id;
  }

  public void setId(int id)
  {
    this.id = id;
  }

  public List<Part> getParts()
  {
    return parts;
  }

  public void setParts(List<Part> parts)
  {
    this.parts = parts;
  }

  public double getWeight()
  {
    return weight;
  }

  public void setWeight(double weight)
  {
    this.weight = weight;
  }

  public PigPart getPigPart()
  {
    return pigPart;
  }


}
