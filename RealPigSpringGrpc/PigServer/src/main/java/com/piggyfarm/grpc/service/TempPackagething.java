package com.piggyfarm.grpc.service;

import java.util.ArrayList;
import java.util.List;

public class TempPackagething {
    private String name;
    private List<TempPigPart> parts;

    public TempPackagething(String name) {
        this.name = name;
        parts = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<TempPigPart> getParts() {
        return parts;
    }

    public void setParts(List<TempPigPart> parts) {
        this.parts = parts;
    }
}
