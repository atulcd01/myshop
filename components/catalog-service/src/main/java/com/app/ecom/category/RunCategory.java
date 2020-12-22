package com.app.ecom.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories("com.app")
@EnableCaching
public class RunCategory {

	@Autowired
	 MongoOperations mongoOperation;
	public static void main(String[] args) {
		SpringApplication.run(RunCategory.class, args);
	}
	
}
