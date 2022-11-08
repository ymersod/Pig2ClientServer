package com.vinsguru.grpc.controller;

import com.vinsguru.grpc.service.PigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class PigController {

    @Autowired
    private PigService pigService;


    @RequestMapping("/piggy")
    public String printMessage(@RequestParam(defaultValue = "Michael") String name, @RequestParam(defaultValue = "Poop") String lastname) {
        return pigService.sendMessage(name,lastname);
    }
}
