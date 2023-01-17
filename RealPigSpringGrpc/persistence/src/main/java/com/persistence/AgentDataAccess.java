package com.persistence;

import com.domain.Pig;
import com.domain.Product;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AgentDataAccess {
	List<Pig> getPigsFromProduct(int productId);
	List<Product> getProductFromPigs(int pigId);
}
