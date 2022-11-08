package com.vinsguru.grpc.controller;

import com.vinsguru.grpc.model.RealPig;
import com.vinsguru.grpc.service.PigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class PigController {

    @Autowired
    private PigService pigService;

    @GetMapping("/")
    public ArrayList<RealPig> getPigsFromProduct(@RequestParam(defaultValue = "1") String id){
        return pigService.findPigsFromProduct(id);
    }


    @RequestMapping("/piggy")
    public String printMessage(@RequestParam(defaultValue = "Michael") String name, @RequestParam(defaultValue = "Poop") String lastname) {
        return pigService.sendMessage(name,lastname);
    }
}
