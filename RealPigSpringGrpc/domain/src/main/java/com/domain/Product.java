package com.domain;

import java.util.ArrayList;
import java.util.List;

public class Product
{
  private int id;
  private double weight;
  private List<Part> parts = new ArrayList<>();

  public Product(int id, double weight, List<Part> parts)
  {
    this.id = id;
    this.weight = weight;
    this.parts = parts;
  }

  public Product(int id, double weight)
  {
    this.id = id;
    this.weight = weight;
  }

  public Product()
  {

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

  public List<Part> getParts()
  {
    return parts;
  }

  public void setParts(List<Part> parts)
  {
    this.parts = parts;
  }
}
