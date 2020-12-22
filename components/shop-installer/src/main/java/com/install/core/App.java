package com.install.core;

public class App {

	public static void main(String[] args) {/*

		// For XML
		//ApplicationContext ctx = new GenericXmlApplicationContext("SpringConfig.xml");

		// For Annotation
		ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringMongoConfig.class);
		MongoOperations mongoOperation = (MongoOperations) ctx.getBean("mongoTemplate");

		User user = new User("mkyong", "password123");
		Product product = new Product( 1,"Lava mobile x109", "Moblies and accessories,Lava, ", "Mobile new ", "Electronics");
		Product product2 = new Product( 2, "Lava mobile x112", "Moblies and accessories,Lava, ", "Mobile new ", "Electronics");

		// save
		mongoOperation.insert(product);
		mongoOperation.insert(product2);

		// now user object got the created id.
		System.out.println("1. product : " + product);

		// query to search user
		Query searchUserQuery = new Query(Criteria.where("name").is("Lava mobile x109"));

		// find the saved user again.
		Product savedProduct = mongoOperation.findOne(searchUserQuery, Product.class);
		System.out.println("2. find - savedProduct : " + savedProduct);

		// update password
		mongoOperation.updateFirst(searchUserQuery, Update.update("password", "new password"),
				User.class);

		// find the updated user object
		Product updatedUser = mongoOperation.findOne(
				new Query(Criteria.where("name").is("Lava mobile x109")), Product.class);

		System.out.println("3. updatedUser : " + updatedUser);

		// delete
		mongoOperation.remove(searchUserQuery, Product.class);

		// List, it should be empty now.
		List<Product> listUser = mongoOperation.findAll(Product.class);
		System.out.println("4. Number of user = " + listUser);

	*/}

}