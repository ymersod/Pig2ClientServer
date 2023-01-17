package com.domain;

public class Part
{
  private int id;
  private double weight;
  private int pigId;

  private PigPartType type;

  public Part(double weight, int pigId, PigPartType type) {
    this.weight = weight;
    this.pigId = pigId;
    this.type = type;
  }

  public Part(int id, double weight, int pigId, PigPartType type) {
    this.id = id;
    this.weight = weight;
    this.pigId = pigId;
    this.type = type;
  }

  public Part() {

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
    return type;
  }

}
