package com.app.ecom.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@ServletComponentScan
@SpringBootApplication
@EnableMongoRepositories("com.app.ecom.order.repository.mongo")
@EnableJpaRepositories("com.app.ecom.order.repository.jpa.**")
@EnableCaching
public class RunOrderService {

	@Autowired
	 MongoOperations mongoOperation;
	public static void main(String[] args) {
		SpringApplication.run(RunOrderService.class, args);
	}
	
}
