package com.piggyfarm.grpc.service;

import com.pigfarm.pig.*;
import com.piggyfarm.grpc.model.RealPig;
import io.grpc.StatusRuntimeException;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class PigService {

    @GrpcClient("pig-service")
    private PigServiceGrpc.PigServiceBlockingStub pigServiceBlockingStub;

    public ArrayList<RealPig> findPigsFromProduct(final String productId)
    {
        try{
            final PigsResponse response = this.pigServiceBlockingStub.findPigsFromProduct(PigsRequest.newBuilder()
                .setProductId(productId)
                .build());

            ArrayList<RealPig> pigsToBeReturned = new ArrayList<>();
            for (PigObject pig: response.getPigsList())
            {
                pigsToBeReturned.add(new RealPig(pig.getId(),pig.getWeight()));
            }

            return pigsToBeReturned;
        }catch(Exception e){
            throw e;
        }
    }

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
