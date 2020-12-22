package com.app.ecom.category;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;


@Repository
public class CategorySearchRepository {
	
	@Autowired
	MongoTemplate mongoTemplate;
	
	public Collection<Category> searchCategory(String text) {
		
		
		Query query = new Query();
		query.addCriteria(Criteria.where("id").regex(text, "i"));
		query.addCriteria(Criteria.where("parent").regex(text, "i"));
		Collection<Category> category = mongoTemplate.find(query,Category.class);
		
		return category;
		
	}

}
