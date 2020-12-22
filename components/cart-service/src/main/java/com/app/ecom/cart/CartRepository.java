package com.app.ecom.cart;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;


public interface CartRepository extends MongoRepository<Cart, String>{

	
	public List<Cart> findByEmail(String email);
	public Cart findById(String id);
	
	
}
