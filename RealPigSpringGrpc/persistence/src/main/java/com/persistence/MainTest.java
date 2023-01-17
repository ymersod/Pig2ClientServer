package com.persistence;

import com.domain.Pig;

import java.time.LocalDate;
import java.util.List;

public class MainTest {
    public static void main(String[] args) {
        DatabaseAccess dBA = new DatabaseAccess();

        LocalDate localDate = LocalDate.parse("2023-01-17");
        List<Pig> pigs = dBA.getFromDate(localDate);

        for (Pig p: pigs) {
            System.out.println(p);
        }
        System.out.println("_____________________________________________");
        pigs = dBA.getFromOrigin("MacD");
        for (Pig p: pigs) {
            System.out.println(p);
        }
    }
}
