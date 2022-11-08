package com.vinsguru.grpc.service;

import com.pigfarm.pig.HelloRequest;
import com.pigfarm.pig.HelloResponse;
import com.pigfarm.pig.PigServiceGrpc;
import io.grpc.StatusRuntimeException;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

@Service
public class PigService {

    @GrpcClient("pig-service")
    private PigServiceGrpc.PigServiceBlockingStub pigServiceBlockingStub;


    public String sendMessage(final String name, final String lastname) {
        try {
            final HelloResponse response = this.pigServiceBlockingStub.sayHello(HelloRequest.newBuilder()
                    .setFirstName(name)
                    .setLastName(lastname)
                    .build());
            return response.getGreeting();
        } catch (final StatusRuntimeException e) {
            return "FAILED with " + e.getStatus().getCode().name();
        }
    }


}
