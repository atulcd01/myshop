package com.app.ecom.order.repository.mongo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.app.ecom.order.model.Address;




public interface AddressRespository extends MongoRepository<Address, String>{

	public List<Address> findByEmail(String email);
	
	
}


