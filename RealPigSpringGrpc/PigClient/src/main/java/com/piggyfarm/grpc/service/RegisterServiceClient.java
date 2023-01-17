package com.piggyfarm.grpc.service;

import com.domain.Part;
import com.domain.Pig;
import com.domain.Product;
import com.domain.Tray;
import com.domain.dtos.RegisterPartDto;
import com.domain.dtos.RegisterPigDto;
import com.domain.dtos.RegisterProductDto;
import com.domain.dtos.RegisterTrayDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class RegisterServiceClient {

	@Autowired
	private RestTemplate restTemplate;

	public Pig registerPig(Pig pig) {
		RegisterPigDto registerPigDto = new RegisterPigDto(
						pig.getWeight(), pig.getOrigin()
		);

		return restTemplate.postForObject("http://localhost:8082/pigs", registerPigDto, Pig.class);
	}

	public Tray registerTray(Tray tray) {
		List<RegisterPartDto> partDtos = new ArrayList<>();

		for (Part part : tray.getParts()) {
			RegisterPartDto registerPartDto = new RegisterPartDto(
							part.getWeight(),
							part.getPartType(),
							part.getPigId()
			);

			partDtos.add(registerPartDto);
		}

		RegisterTrayDto registerTrayDto = new RegisterTrayDto(
						tray.getId(),
						tray.getPartType(),
						tray.getWeight(),
						partDtos
		);

		return restTemplate.postForObject("http://localhost:8082/parts", registerTrayDto, Tray.class);
	}

	public Product registerProduct(Product product) {
		RegisterProductDto registerProductDto = new RegisterProductDto(
						product.getId(),
						product.getWeight(),
						product.getParts()
		);

		return restTemplate.postForObject("http://localhost:8082/products", registerProductDto, Product.class);
	}
}
