package com.vinsguru.grpc.model;

public class Product
{
  private String id;
  private double weight;

  public Product(String id, double weight)
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
