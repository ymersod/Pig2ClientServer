package com.piggyfarm.grpc.service;

import com.pigfarm.pig.*;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@GrpcService
public class PigServerService extends PigServiceGrpc.PigServiceImplBase {

    DataBaseAccess dataBaseAccess;

    public PigServerService(DataBaseAccess dataBaseAccess) {
        this.dataBaseAccess = dataBaseAccess;
    }

    //DIS is where we call the JPA to do different stuff
    @Override
    public void findPigsFromProduct(PigsRequest request, StreamObserver<PigsResponse> responseObserver)
    {
        int productId = request.getProductId();

        List<PigObject> pigs = dataBaseAccess.getPigsFromProduct(productId);

        PigsResponse response = PigsResponse.newBuilder()
            .addAllPigs(pigs)
            .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void findProductsFromPigs(ProductRequest request, StreamObserver<ProductResponse>  responseObserver)
    {
        int pigId = request.getPigId();
        List<ProductObject> products = dataBaseAccess.getProductFromPigs(pigId); //Indeholder products som er fundet via database magic

        ProductResponse response = ProductResponse.newBuilder()
            .addAllProducts(products)
            .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void registerPig(PigToBeRegistered piggy, StreamObserver<PigObject> pigObject)
    {
        double pigWeight = piggy.getWeight();

        PigObject piggyRegistered = dataBaseAccess.registerPig(pigWeight);

        pigObject.onNext(piggyRegistered);
        pigObject.onCompleted();
    }

    @Override
    public void registerTray(TrayToBeRegistered trayToBeRegistered, StreamObserver<TrayResponse> trayResponse)
    {
        System.out.println("got here boyssss");
        TrayResponse tray = dataBaseAccess.registerPigParts(trayToBeRegistered);
        trayResponse.onNext(tray);
        trayResponse.onCompleted();
    }

    @Override
    public void registerProduct(ProductToBeRegistered productToBeRegistered, StreamObserver<ProductObject> productObject)
    {
        ProductObject product = dataBaseAccess.registerProduct(productToBeRegistered);

        productObject.onNext(product);
        productObject.onCompleted();
    }



}
