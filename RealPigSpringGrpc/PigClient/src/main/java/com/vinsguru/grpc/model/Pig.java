package com.vinsguru.grpc.model;

public class Pig
{
  private String id;
  private double weight;

  public Pig(String id, double weight)
  {
    this.id = id;
    this.weight = weight;
  }

  public String getId()
  {
    return id;
  }

  public void setId(String id)
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
}
