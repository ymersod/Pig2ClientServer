package com.registerservice.rest;

import com.domain.Product;
import com.persistence.RegisterDataAccess;
import com.domain.dtos.RegisterProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductsController {

	@Autowired
	private RegisterDataAccess registerDataAccess;

	@PostMapping("/")
	public Product registerProduct(@RequestBody RegisterProductDto product) {
		return registerDataAccess.registerProduct(product);
	}
}
