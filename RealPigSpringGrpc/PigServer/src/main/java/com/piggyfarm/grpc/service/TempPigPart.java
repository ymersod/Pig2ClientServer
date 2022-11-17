package com.piggyfarm.grpc.service;

public class TempPigPart {
    private double weight;
    private int pigId;
    private String name;
    private int id;

    public TempPigPart(double weight, int pigId, String name) {
        this.weight = weight;
        this.pigId = pigId;
        this.name = name;
    }

    public TempPigPart(double weight, int pigId, String name, int id) {
        this.weight = weight;
        this.pigId = pigId;
        this.name = name;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public double getWeight() {
        return weight;
    }

    public int getPigId() {
        return pigId;
    }

    public String getName() {
        return name;
    }
}
