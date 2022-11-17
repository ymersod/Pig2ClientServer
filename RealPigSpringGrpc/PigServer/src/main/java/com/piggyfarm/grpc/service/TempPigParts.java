package com.piggyfarm.grpc.service;

import java.util.ArrayList;
import java.util.List;

public class TempPigParts {
    private String trayId;
    private List<TempPigPart> parts;

    public TempPigParts(String trayId) {
        this.trayId = trayId;
        parts = new ArrayList<>();
    }

    public String getTrayId() {
        return trayId;
    }

    public List<TempPigPart> getParts() {
        return parts;
    }

    public void setParts(List<TempPigPart> parts) {
        this.parts = parts;
    }
}
