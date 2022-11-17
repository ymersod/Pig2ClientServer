package com.piggyfarm.grpc.model;

public class Part
{
  private int id;
  private double weight;
  private int pigId;

  private PigPart pigPart;

  public Part(double weight, int pigId, PigPart pigPart)
  {
    this.weight = weight;
    this.pigId = pigId;
    this.pigPart = pigPart;
  }

  public Part(int id, double weight, int pigId, PigPart pigPart)
  {
    this.id = id;
    this.weight = weight;
    this.pigId = pigId;
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
    return pigPart;
  }

  public void setPigPart(PigPart pigPart) {
    this.pigPart = pigPart;
  }
}
