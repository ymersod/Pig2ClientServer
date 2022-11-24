package com.piggyfarm.grpc.slaughterhouse;


import com.piggyfarm.grpc.model.Pig;
import com.piggyfarm.grpc.model.Product;
import com.piggyfarm.grpc.service.PigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class Agent {

    @Autowired
    private PigService pigService;


    public HashMap<Integer,Product> findBadPigsFromBadProduct(Product product)
    {
        List<Pig> badPigs = pigService.findPigsFromProduct(product.getId());
        HashMap<Integer, Product> badProducts = new HashMap<>();

        for (Pig badPig: badPigs) {
            List<Product> badProductsFromBadPig = pigService.findProductFromPig(badPig.getId());
            for (Product stinky: badProductsFromBadPig) {
                badProducts.put(stinky.getId(),stinky);
            }
        }
        return badProducts;

    }

}
