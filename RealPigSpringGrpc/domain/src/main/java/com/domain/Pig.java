package com.domain;

public class Pig
{
  private int id;
  private double weight;

  public Pig(int id, double weight)
  {
    this.id = id;
    this.weight = weight;
  }

  public Pig(double weight)
  {
    this.weight = weight;
  }

  public Pig() {

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
}
