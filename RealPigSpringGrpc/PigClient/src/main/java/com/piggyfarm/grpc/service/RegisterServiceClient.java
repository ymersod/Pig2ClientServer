package com.piggyfarm.grpc.service;

import com.domain.Pig;
import com.domain.Product;
import com.domain.Tray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RegisterServiceClient {

	@Autowired
	private RestTemplate restTemplate;

	public Pig registerPig(Pig pig) {
		return restTemplate.postForObject("http://localhost:8082/pigs", pig, Pig.class);
	}

	public Tray registerTray(Tray tray) {
		return restTemplate.postForObject("http://localhost:8082/trays", tray, Tray.class);
	}

	public Product registerProduct(Product product) {
		return restTemplate.postForObject("http://localhost:8082/products", product, Product.class);
	}
}
