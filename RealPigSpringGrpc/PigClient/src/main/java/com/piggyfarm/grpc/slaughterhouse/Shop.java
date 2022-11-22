package com.piggyfarm.grpc.slaughterhouse;

import com.piggyfarm.grpc.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class Shop implements Runnable
{

  @Autowired
  private Agent agent;

  private HashMap<Integer,Product> productsInShop;

  public Shop()
  {
    productsInShop = new HashMap<>();
    run();
  }
  public void deliverProduct(Product packageToSend)
  {
    productsInShop.put(packageToSend.getId(),packageToSend);
  }

  @Override
  public void run() {
    while(true)
    {
      try {
        Thread.sleep(10000);

        double checkIfBad = Math.random();

        if(checkIfBad <= 0.1)
        {
          Integer[] products = productsInShop.keySet().toArray(new Integer[0]);

          int randomProduct = (int)Math.floor(Math.random() * products.length);
          int key = products[randomProduct];

          foundBadProduct(productsInShop.get(key));
        }


      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
    }
  }


  private void foundBadProduct(Product badProduct)
  {
    removeBadProducts(agent.findBadPigsFromBadProduct(badProduct));
  }

  private void removeBadProducts(HashMap<Integer,Product> badProducts)
  {
    System.out.println("Removing smth");
    badProducts.forEach((key, value) -> productsInShop.remove(key));
  }
}
