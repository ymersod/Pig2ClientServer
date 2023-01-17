package com.domain;

public class Part
{
  private int id;
  private double weight;
  private int pigId;

  private final PigPartType type;

  public Part(double weight, int pigId, PigPartType type) {
    this.weight = weight;
    this.pigId = pigId;
    this.type = type;
  }

  public Part(int id, double weight, int pigId, PigPartType partType)

  {
    this.id = id;
    this.weight = weight;
    this.pigId = pigId;
    this.type = partType;
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


  public PigPartType getType() {
    return type;
  }

}
