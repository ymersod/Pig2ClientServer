package com.piggyfarm.grpc.service;

import com.pigfarm.pig.PigObject;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        DataBaseAccess dataBaseAccess = new DataBaseAccess();

        //System.out.println(dataBaseAccess.registerPig(25.55).getId());
        TempPigPart p1, p2, p3;
        p1 = new TempPigPart(23.1,3,"HEAD", 7);
        p2 = new TempPigPart(23.5,2,"LEG", 6);
        p3 = new TempPigPart(32.7, 1, "BOTTOM",5);
        List<TempPigPart> parts = new ArrayList<>();
        parts.add(p1);
        parts.add(p2);
        parts.add(p3);

        /*List<PigObject> test = dataBaseAccess.getPigsFromProduct(1);
        for (PigObject t: test) {
            System.out.println(t.getId());
        }*/

       /* TempPigParts pigParts = new TempPigParts("KARLMARGJORDEINTETFORKERT");
        pigParts.setParts(parts);
        dataBaseAccess.registerPigParts(pigParts);*/

        TempPackagething packagething = new TempPackagething("Mother");
        packagething.setParts(parts);
        dataBaseAccess.registerProduct(packagething);
    }
}
