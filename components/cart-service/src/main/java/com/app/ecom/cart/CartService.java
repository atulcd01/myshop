package com.app.ecom.cart;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class CartService {


	@Autowired
	private CartRepository cartRepository;
	


	
	@Autowired
    MongoTemplate mongoTemplate;

	public   List<Cart> getCart(String email,String applictionId){
		
		Query query = new Query();
		query.addCriteria(Criteria.where("email").is(email).and("appId").is(applictionId));

		List<Cart> cartList = mongoTemplate.find(query, Cart.class);
		return cartList;
	}
	
	public   boolean getCart(String email ,String applictionId,String productId){
		Query query = new Query();
		query.addCriteria(Criteria.where("email").is(email).and("appId").is(applictionId).and("productId").is(productId));

		long count = mongoTemplate.count(query, Cart.class);
		System.out.println(email+ applictionId+ productId + count);
		return (count==0 ? false : true);
	}
	
	

	public   Cart save(Cart cart){
		return  cartRepository.save(cart);
	}
	public   Cart addToCart(String id){
		return  cartRepository.findById(id);
	}

	
	public   void delete(Cart cart){
		  cartRepository.delete(cart);
	}
	
	public   void delete(String cartid){
		  cartRepository.delete(cartid);
	}
	
	public void deleteAll(Cart cart) {
		
		cartRepository.deleteAll();
		
	}





	public Cart findById(String id) {
		return cartRepository.findById(id);
	}
}
