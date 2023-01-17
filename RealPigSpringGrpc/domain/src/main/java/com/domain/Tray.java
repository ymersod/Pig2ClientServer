package com.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Tray
{
  private static final int MAX_WEIGHT = 51;

  private String id;
  private List<Part> parts; //update
  private double weight;

  private final PigPartType pigPart;

  public Tray(PigPartType pigPart)
  {
    this.pigPart = pigPart;

    id = UUID.randomUUID().toString();
    parts = new ArrayList<>();
    weight = 0;
  }

  public Tray(String id, List<Part> parts, double weight, PigPartType pigPart)
  {
    this.id = id;
    this.parts = parts;
    this.weight = weight;
    this.pigPart = pigPart;
  }

  public void addPart(Part part) throws RuntimeException
  {
    boolean isGonnaBeFull = (weight + part.getWeight()) > MAX_WEIGHT;

    if (isGonnaBeFull) {
      throw new RuntimeException("Tray is full");
    }

    weight += part.getWeight();
    parts.add(part);
  }

  public String getId()
  {
    return id;
  }

  public void setId(String id)
  {
    this.id = id;
  }

  public List<Part> getParts()
  {
    return parts;
  }

  public double getWeight()
  {
    return weight;
  }

  public PigPartType getPigPart()
  {
    return pigPart;
  }


}
