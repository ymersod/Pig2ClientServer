package com.piggyfarm.grpc.slaughterhouse;

import com.domain.Product;
import com.piggyfarm.grpc.service.AgentServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class Shop implements Runnable
{

  @Autowired
  private AgentServiceClient agentService;

  private HashMap<Integer,Product> productsInShop;

  public Shop()
  {
    productsInShop = new HashMap<>();
    new Thread(this).start();
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
          if (products.length != 0) {
            int key = products[randomProduct];

            foundBadProduct(productsInShop.get(key));
          }
        }


      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
    }
  }


  private void foundBadProduct(Product badProduct)
  {
    HashMap<Integer, Product> badPigsFromBadProduct = agentService.findBadPigsFromBadProduct(badProduct);
    removeBadProducts(badPigsFromBadProduct);
  }

  private void removeBadProducts(HashMap<Integer,Product> badProducts)
  {
    badProducts.forEach((key, value) -> productsInShop.remove(key));
  }
}
