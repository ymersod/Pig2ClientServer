package com.piggyfarm.grpc.model;

public class Part
{
  private int id;
  private double weight;
  private int pigId;

  private final PigPart pigpart;

  public Part(int id, double weight, int pigId, PigPart pigpart)

  {
    this.id = id;
    this.weight = weight;
    this.pigId = pigId;
    this.pigpart = pigpart;
  }
  public int getId()
  {
    return id;
  }

  public void setId(int id)
  {
    this.id = id;
  }

  public double getWeight()
  {
    return weight;
  }

  public void setWeight(double weight)
  {
    this.weight = weight;
  }

  public int getPigId()
  {
    return pigId;
  }

  public void setPigId(int pigId)
  {
    this.pigId = pigId;
  }


  public PigPart getPigPart() {
    return pigpart;
  }

  public PigPart getPigpart()
  {
    return pigpart;
  }
}
