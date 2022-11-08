package com.piggyfarm.grpc.controller;


import com.piggyfarm.grpc.model.Pig;
import com.piggyfarm.grpc.model.Product;
import com.piggyfarm.grpc.service.PigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class PigController {

    @Autowired
    private PigService pigService;

    @GetMapping("/pigs" )
    public ArrayList<Pig> getPigsFromProduct(@RequestParam String productId){
        return pigService.findPigsFromProduct(productId);
    }

    @GetMapping("/products")
    public ArrayList<Product> getProductsFromPigs(@RequestParam String pigId){
        return pigService.findProductFromPig(pigId);
    }
    @RequestMapping("/piggy")
    public String printMessage(@RequestParam(defaultValue = "Michael") String name, @RequestParam(defaultValue = "Poop") String lastname) {
        return pigService.sendMessage(name,lastname);
    }
}
