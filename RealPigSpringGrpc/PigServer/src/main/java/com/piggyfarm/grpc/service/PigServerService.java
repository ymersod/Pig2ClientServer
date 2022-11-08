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
        int productId = Integer.parseInt(request.getProductId());

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
        int pigId = Integer.parseInt(request.getPigId());
        List<ProductObject> products = dataBaseAccess.getProductFromPigs(pigId); //Indeholder products som er fundet via database magic

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
