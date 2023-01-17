package com.domain;

public class Pig
{
  private int id;
  private double weight;

  private String origin;
  private static String[] Origins = {"Lars Tyndskid", "Mette Mink", "MacD"};

  public Pig(int id, double weight, String origin) {
    this.id = id;
    this.weight = weight;
    this.origin = origin;
  }

  public Pig(int id, double weight)
  {
    this.id = id;
    this.weight = weight;
  }

  public Pig(double weight)
  {
    this.weight = weight;
    origin = Origins[(int) (Math.random() * 3)];
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

  public String getOrigin() {
    return origin;
  }

  @Override
  public String toString() {
    return "Pig{" +
            "id=" + id +
            ", weight=" + weight +
            ", origin='" + origin + '\'' +
            '}';
  }
}
