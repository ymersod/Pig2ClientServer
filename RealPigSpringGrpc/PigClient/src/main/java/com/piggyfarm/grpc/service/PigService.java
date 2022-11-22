package com.piggyfarm.grpc.service;

import com.pigfarm.pig.*;

import com.piggyfarm.grpc.model.*;
import io.grpc.StatusRuntimeException;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PigService {

    @GrpcClient("pig-service")
    private com.pigfarm.pig.PigServiceGrpc.PigServiceBlockingStub pigServiceBlockingStub;

    public ArrayList<Pig> findPigsFromProduct(final int productId)
    {
        try{
            final PigsResponse response = this.pigServiceBlockingStub.findPigsFromProduct(PigsRequest.newBuilder()
                .setProductId(productId)
                .build());

            ArrayList<Pig> pigsToBeReturned = new ArrayList<>();
            for (PigObject pig: response.getPigsList())
            {
                pigsToBeReturned.add(new Pig(pig.getId(),pig.getWeight()));
            }

            return pigsToBeReturned;
        }catch(Exception e){
            throw e;
        }
    }

    public ArrayList<Product> findProductFromPig(final int pigsId){
        try{
            final ProductResponse response = this.pigServiceBlockingStub.findProductsFromPigs(ProductRequest.newBuilder()
                .setPigId(pigsId)
                .build());

            ArrayList<Product> productsToBeReturned = new ArrayList<Product>();
            for (ProductObject product: response.getProductsList())
            {
                productsToBeReturned.add(new Product(product.getId(),product.getWeight()));
            }
            return productsToBeReturned;
        }catch(Exception e){
            System.out.println(e.getStackTrace());
            return null;
        }
    }



    public Pig registerPig(final Pig pig)
    {
        try {
            PigObject registeredPig = this.pigServiceBlockingStub.registerPig(PigToBeRegistered.newBuilder()
                    .setWeight(pig.getWeight())
                    .build());


            //Conversion from gRPC object to domain object
            Pig piggy = new Pig(registeredPig.getId(),registeredPig.getWeight());

            return piggy;
        }
        catch(Exception e){
            System.out.println(e.getStackTrace());
            return null;
        }
    }

    public Tray registerTray(final Tray tray){
        try
        {
            List<PartObject> partsToRegister = new ArrayList<>();

            for (Part specPart : tray.getParts())
            {
                partsToRegister.add(PartObject.newBuilder().setWeight(specPart.getWeight())
                    .setPartType(specPart.getPartType().toString()).setPigId(specPart.getPigId()).build());
            }

            TrayResponse registeredTray = this.pigServiceBlockingStub.registerTray(
                TrayToBeRegistered.newBuilder().setTrayId(tray.getId()).addAllPartsToBeRegistered(partsToRegister).build());

            List<Part> partsToReturn = new ArrayList<>();

            for (RegisteredPartObject specPart : registeredTray.getRegisteredPartsList())
            {
                partsToReturn.add(new Part(specPart.getPartId(), specPart.getWeight(),
                    specPart.getPigId(), PigPartType.valueOf(specPart.getPartType())));
            }
            Tray trayToReturn = new Tray(registeredTray.getTrayId(),
                partsToReturn, registeredTray.getWeight(),
                PigPartType.valueOf(registeredTray.getRegisteredParts(0).getPartType()));
            return trayToReturn;
        }catch(Exception e){
            System.out.println(e.getStackTrace());
            return null;
        }
    }

    public Product registerProduct(final Product product) {
        try{
            List<RegisteredPartObject> parts = new ArrayList<>();
            for (Part specPart : product.getParts())
            {
                parts.add(RegisteredPartObject.newBuilder().setWeight(specPart.getWeight())
                    .setPartId(specPart.getId())
                    .setPartType(specPart.getPartType().toString())
                    .setPigId(specPart.getPigId())
                    .build());
            }

            ProductObject registeredProduct = this.pigServiceBlockingStub.registerProduct(
                ProductToBeRegistered.newBuilder()
                    .setWeight(product.getWeight())
                    .addAllParts(parts)
                    .build());

            List<Part> partsToReturn = new ArrayList<>();

            for (RegisteredPartObject specPart : registeredProduct.getPartsList())
            {
                partsToReturn.add(new Part(specPart.getPartId(), specPart.getWeight(),
                    specPart.getPigId(), PigPartType.valueOf(specPart.getPartType())));
            }

            Product productToReturn = new Product(registeredProduct.getId(),
                registeredProduct.getWeight(), partsToReturn);

            return productToReturn;
        } catch(Exception e){
            System.out.println(e.getStackTrace());
            return null;
        }

    }


}
