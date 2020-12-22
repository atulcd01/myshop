package com.app.ecom.cart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@ServletComponentScan
@SpringBootApplication
@EnableMongoRepositories("com.app")
@EnableCaching
public class RunCartService {

	@Autowired
	 MongoOperations mongoOperation;
	public static void main(String[] args) {
		SpringApplication.run(RunCartService.class, args);
	}
	
}
