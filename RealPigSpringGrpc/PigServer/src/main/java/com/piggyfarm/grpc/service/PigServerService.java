package com.piggyfarm.grpc.service;

import com.pigfarm.pig.*;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

import java.util.ArrayList;
import java.util.stream.Stream;

@GrpcService
public class PigServerService extends PigServiceGrpc.PigServiceImplBase {

    //DIS is where we call the JPA to do different stuff
    @Override
    public void findPigsFromProduct(PigsRequest request, StreamObserver<PigsResponse> responseObserver)
    {
        String productId = request.getProductId();

        ArrayList<PigObject> pigs = new ArrayList<>(); //Indeholder pigs som er fundet via database magic

        /*
        PigObject pig = PigObject.newBuilder()
            .setId("1")
            .setWeight(30.10)
            .build();

        pigs.add(pig);

            Dette er Database Magi
         */

        PigsResponse response = PigsResponse.newBuilder()
            .addAllPigs(pigs)
            .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void findProductsFromPigs(ProductRequest request, StreamObserver<ProductResponse>  responseObserver)
    {
        String pigId = request.getPigId();
        ArrayList<ProductObject> products = new ArrayList<>(); //Indeholder products som er fundet via database magic

        //Database Magic

        ProductResponse response = ProductResponse.newBuilder()
            .addAllProducts(products)
            .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void sayHello(HelloRequest request, StreamObserver<HelloResponse> responseObserver) {


        String greeting = String.format("Hello, %s %s!",
                request.getFirstName(),
                request.getLastName());
        HelloResponse response = HelloResponse.newBuilder()
                .setGreeting(greeting)
                .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();

    }

}
