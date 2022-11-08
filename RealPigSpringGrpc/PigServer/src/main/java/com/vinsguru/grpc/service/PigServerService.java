package com.vinsguru.grpc.service;

import com.pigfarm.pig.HelloRequest;
import com.pigfarm.pig.HelloResponse;
import com.pigfarm.pig.PigServiceGrpc;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class PigServerService extends PigServiceGrpc.PigServiceImplBase {


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
