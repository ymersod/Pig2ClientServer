package com.piggyfarm.grpc.model;

import com.domain.Part;
import com.domain.Product;

import java.util.List;

public class HeadAndBottomProduct extends Product
{

  private Part head;
  private Part bottom;
  private boolean isFull;


  public HeadAndBottomProduct(int id, double weight, List<Part> parts)
  {
    super(id, weight, parts);
  }

  public HeadAndBottomProduct(int id, double weight)
  {
    super(id, weight);
  }

  public HeadAndBottomProduct(int id, double weight, List<Part> parts,
      Part head, Part bottom)
  {
    super(id, weight, parts);
    this.head = head;
    this.bottom = bottom;
  }

  public HeadAndBottomProduct(int id, double weight, Part head, Part bottom)
  {
    super(id, weight);
    this.head = head;
    this.bottom = bottom;
  }

  public HeadAndBottomProduct()
  {
    super();
  }

  public Part getHead()
  {
    return head;
  }

  public void setHead(Part head)
  {
    this.head = head;
    super.getParts().add(head);
    if (getHead() != null && getBottom() != null)
      isFull = true;
  }

  public Part getBottom()
  {
    return bottom;
  }

  public void setBottom(Part bottom)
  {
    this.bottom = bottom;
    super.getParts().add(bottom);
    if (getHead() != null && getBottom() != null)
      isFull = true;
  }

  public boolean isFull()
  {
    return isFull;
  }
}
