package com.piggyfarm.grpc.controller;

import com.piggyfarm.grpc.model.RealPig;
import com.piggyfarm.grpc.service.PigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class PigController {

    @Autowired
    private PigService pigService;

    @GetMapping("/pigs" )
    public ArrayList<RealPig> getPigsFromProduct(@RequestParam String id){
        return pigService.findPigsFromProduct(id);
    }


    @RequestMapping("/piggy")
    public String printMessage(@RequestParam(defaultValue = "Michael") String name, @RequestParam(defaultValue = "Poop") String lastname) {
        return pigService.sendMessage(name,lastname);
    }
}
