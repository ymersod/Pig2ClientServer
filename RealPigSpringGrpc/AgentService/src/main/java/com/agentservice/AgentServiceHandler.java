package com.agentservice;

import AgentService.AgentServiceGrpc;
import AgentService.FindBadPigsFromBadProductRequest;
import AgentService.FindBadPigsFromBadProductResponse;
import AgentService.ProductObject;
import com.domain.Pig;
import com.domain.Product;
import com.persistence.AgentDataAccess;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@GrpcService
public class AgentServiceHandler extends AgentServiceGrpc.AgentServiceImplBase {

	@Autowired
	private AgentDataAccess dataAccess;

	public void findBadPigsFromBadProduct(FindBadPigsFromBadProductRequest request, StreamObserver<FindBadPigsFromBadProductResponse> responseObserver) {
		// find all pigs from product
		ProductObject product = request.getProduct();

		List<Pig> badPigs = dataAccess.getPigsFromProduct(product.getId());

		// find bad products from pigs
		List<Product> badProducts = new ArrayList<>();

		badPigs.forEach((badPig) -> {
			List<Product> badProductsFromBadPig = dataAccess.getProductFromPigs(badPig.getId());
			badProducts.addAll(badProductsFromBadPig);
		});

		// convert products to product objects
		List<ProductObject> badProductsObject = new ArrayList<>();

		badProducts.forEach((badProduct) -> {
			ProductObject badProductObject = ProductObject.newBuilder()
					.setId(badProduct.getId())
					.setWeight(badProduct.getWeight())
					.build();

			badProductsObject.add(badProductObject);
		});

		// create and return response object
		FindBadPigsFromBadProductResponse response = FindBadPigsFromBadProductResponse.newBuilder()
				.addAllProducts(badProductsObject)
				.build();

		responseObserver.onNext(response);
		responseObserver.onCompleted();
	}
}
