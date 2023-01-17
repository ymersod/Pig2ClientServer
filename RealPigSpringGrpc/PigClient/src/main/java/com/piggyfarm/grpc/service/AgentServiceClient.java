package com.piggyfarm.grpc.service;

import AgentService.AgentServiceGrpc;
import AgentService.FindBadPigsFromBadProductRequest;
import AgentService.FindBadPigsFromBadProductResponse;
import AgentService.ProductObject;
import com.domain.Product;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.List;

@Service
public class AgentServiceClient {

    @GrpcClient("agent-service")
    private AgentServiceGrpc.AgentServiceBlockingStub agentServiceBlockingStub;

    public HashMap<Integer, Product> findBadPigsFromBadProduct(Product badProduct) {
        ProductObject productObject = ProductObject.newBuilder()
                .setId(badProduct.getId())
                .setWeight(badProduct.getWeight())
                .build();

        FindBadPigsFromBadProductRequest request = FindBadPigsFromBadProductRequest.newBuilder()
                .setProduct(productObject)
                .build();

        FindBadPigsFromBadProductResponse response = agentServiceBlockingStub.findBadPigsFromBadProduct(request);

        List<ProductObject> productObjects = response.getProductsList();

        HashMap<Integer, Product> badProducts = new HashMap<>();

        productObjects.forEach((po) -> {
            Product product = new Product(po.getId(), po.getWeight());
            badProducts.put(product.getId(), product);
        });

        return badProducts;
    }
}
