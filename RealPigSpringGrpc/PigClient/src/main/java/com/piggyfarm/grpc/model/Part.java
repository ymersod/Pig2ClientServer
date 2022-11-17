package com.piggyfarm.grpc.model;

public class Part
{
  private int id;
  private double weight;
  private int pigId;

  private PigPartType partType;

  public Part(double weight, int pigId, PigPartType partType)
  {
    this.weight = weight;
    this.pigId = pigId;
    this.partType = partType;
  }

  public Part(int id, double weight, int pigId, PigPartType partType)
  {
    this.id = id;
    this.weight = weight;
    this.pigId = pigId;
    this.partType = partType;
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

  public PigPartType getPartType() {
    return partType;
  }

  public void setPartType(PigPartType partType) {
    this.partType = partType;
  }
}
