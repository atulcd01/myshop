package com.install.core;

import java.util.List;
import java.util.regex.Pattern;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.install.config.SpringMongoConfig;
import com.install.model.Cart;
import com.install.model.Category;
import com.install.model.CategoryVO;
import com.install.model.Filter;

public class DataStructure {

	public static void main(String[] args) {

		// For XML
		//ApplicationContext ctx = new GenericXmlApplicationContext("SpringConfig.xml");

		// For Annotation
		ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringMongoConfig.class);
		MongoOperations mongoOperation = (MongoOperations) ctx.getBean("mongoTemplate");

		//mongoOperation.dropCollection(Category.class);
		mongoOperation.dropCollection(Cart.class);
		// save createSampleData
		/*mongoOperation.insert(new Category("Electronics" ,"0", 1, null));
		mongoOperation.insert(new Category("Home_and_Furniture" ,"0", 2, null));
		
		mongoOperation.insert(new Category("Cameras_and_photograph" ,"Electronics", 1, null));
		mongoOperation.insert(new Category("Shop_top_product" ,"Electronics", 2, null));
		mongoOperation.insert(new Category("Cell_Phones_and_Accessories" ,"Electronics", 3, null));
		
		mongoOperation.insert(new Category("Digital_cameras" ,"Cameras_and_photograph", 1, null));
		mongoOperation.insert(new Category("Camcoders" ,"Cameras_and_photograph", 2, null));
		mongoOperation.insert(new Category("Lenses_and_Filters" ,"Cameras_and_photograph", 3, null));
		mongoOperation.insert(new Category("Tripods_and_suppports" ,"Cameras_and_photograph", 4, null));
		mongoOperation.insert(new Category("Lighting_and_Studio" ,"Cameras_and_photograph", 5, null));
		
		mongoOperation.insert(new Category("Ipad" ,"Shop_top_product", 1, null));
		mongoOperation.insert(new Category("Iphone" ,"Shop_top_product", 2, null));
		mongoOperation.insert(new Category("Ipod" ,"Shop_top_product", 3, null));
		mongoOperation.insert(new Category("Blackberry" ,"Shop_top_product", 4, null));
		
		mongoOperation.insert(new Category("cell_phones_and_Smartphones" ,"Cell_Phones_and_Accessories", 1, null));
		mongoOperation.insert(new Category("HeadSets" ,"Cell_Phones_and_Accessories", 2, null));
		mongoOperation.insert(new Category("Batteries" ,"Cell_Phones_and_Accessories", 3, null));
		mongoOperation.insert(new Category("Cables_and_Adapters" ,"Cell_Phones_and_Accessories", 4, null));
		
		
		mongoOperation.insert(new Category("Nokia" ,"cell_phones_and_Smartphones", 1, null));
		mongoOperation.insert(new Category("Samsung" ,"cell_phones_and_Smartphones", 2, null));
		mongoOperation.insert(new Category("Apple" ,"cell_phones_and_Smartphones", 3, null));
		mongoOperation.insert(new Category("HTC" ,"cell_phones_and_Smartphones", 4, null));
		mongoOperation.insert(new Category("Vyacheslav" ,"cell_phones_and_Smartphones", 5, null));
		
		
		Filter filter = new Filter();
		filter.setPrize(8990);
		mongoOperation.insert(new Category("Samsung_Galaxy_On7" ,"Samsung", 1, filter));
		mongoOperation.insert(new Category("Samsung_Galaxy_J5" ,"Samsung", 2, filter));
		mongoOperation.insert(new Category("Samsung_Galaxy_J7_Prime" ,"Samsung", 3, filter));
		mongoOperation.insert(new Category("Samsung_Galaxy_J2" ,"Samsung", 4, filter));
		
			
			
		
		
		mongoOperation.insert(new Category("Kitchen_n_Dining" ,"Home_and_Furniture", 1, null));
		mongoOperation.insert(new Category("Dining_n_Serving" ,"Home_and_Furniture", 2, null));
		mongoOperation.insert(new Category("Kitchen_Storage" ,"Home_and_Furniture", 3, null));
		mongoOperation.insert(new Category("Furniture" ,"Home_and_Furniture", 4, null));
		mongoOperation.insert(new Category("House_Keeping_&_Laundry" ,"Home_and_Furniture", 5, null));
		
		mongoOperation.insert(new Category("Pots_and_Pans" ,"Kitchen_n_Dining", 1, null));
		mongoOperation.insert(new Category("Pressure_Cookers" ,"Kitchen_n_Dining", 2, null));
		mongoOperation.insert(new Category("Kitchen_Tools" ,"Kitchen_n_Dining", 3, null));
		mongoOperation.insert(new Category("Gas_Stoves" ,"Cameras_and_photograph", 4, null));
		
		
		mongoOperation.insert(new Category("Coffee_Mugs" ,"Dining_n_Serving", 1, null));
		mongoOperation.insert(new Category("Dinnerware_and_Crockery" ,"Dining_n_Serving", 2, null));
		mongoOperation.insert(new Category("Bar_and_Glassware" ,"Dining_n_Serving", 3, null));
		
		
	
		mongoOperation.insert(new Category("Lunch_Boxes" ,"Kitchen_Storage", 1, null));
		mongoOperation.insert(new Category("Flasks_and_Casseroles" ,"Kitchen_Storage", 2, null));
		mongoOperation.insert(new Category("Containers_and_Bottles" ,"Kitchen_Storage", 3, null));
	
		
		
		mongoOperation.insert(new Category("Beds" ,"Furniture", 1, null));
		mongoOperation.insert(new Category("Dining_tables" ,"Furniture", 2, null));
		mongoOperation.insert(new Category("Sofas" ,"Furniture", 3, null));
		mongoOperation.insert(new Category("TV_Cabinets" ,"Furniture", 4, null));
		mongoOperation.insert(new Category("Mattresses" ,"Furniture", 5, null));
		mongoOperation.insert(new Category("Coffee_and_Centre_Tables" ,"Furniture", 1, null));
		mongoOperation.insert(new Category("Office_and_Study_Furniture" ,"Furniture", 2, null));
		mongoOperation.insert(new Category("Storage" ,"Furniture", 3, null));
		mongoOperation.insert(new Category("Bean_Bags" ,"Furniture", 4, null));
		mongoOperation.insert(new Category("Collapsible_Wardrobes" ,"Furniture", 5, null));
		
		filter.setPrize(10000);
		mongoOperation.insert(new Category("Godrej_Interio_FLOYD_SINGLE_BED_Engineered_Wood_Single_Bed1","Beds",1,filter));
		mongoOperation.insert(new Category("FurnitureKraft_Metal_Queen_Bed_With_Storage","Beds",2,filter));
		mongoOperation.insert(new Category("HomeTown_Bali_Bolton_Engineered_Wood_King_Bed_With_Storage","Beds",3,filter));
		mongoOperation.insert(new Category("FurnitureKraft_Metal_Queen_Bed","Beds",4,filter));
		
		
		
		Category baseProduct = new Category("base_","x",0,null);
		baseProduct.setChildren(getChild("0",  mongoOperation,null));
		CategoryVO pvo = new CategoryVO(baseProduct);
		
		search("samsung", mongoOperation);*/
		
		/*List<Category> srResult = pvo.search("samsung");
		
		for (Category category : srResult) {
			System.out.println(category.getId());
		}
		*/
		//pvo.print();
			
		// has children
			
		

	}
	
	
	public  static List<Category> search(String wildcard , MongoOperations mongoOperation){
		 
		Query searchUserQuery = new Query(Criteria.where("breadcrumb").regex(Pattern.compile(wildcard, Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE)));
		List<Category> searchCategory = mongoOperation.find(searchUserQuery, Category.class);
		System.out.println(searchUserQuery);
		
		for (Category category : searchCategory) {
			System.out.println("result >>"+ category.getId());
		}
			return searchCategory;
	}
	
	private static String getBreadCrumb(String path,String value,String name,MongoOperations mongoOperation){
		
		
		//path = value+path;
		 path = "<a href=\"/protected/view/"+value+"\"  >"+name.replaceAll("_", " ")+"</a>"+path;;
		 Query searchUserQuery = new Query(Criteria.where("id").is(value));
		 Category findCategory = mongoOperation.findOne(searchUserQuery, Category.class);
		if(!"0".equals(findCategory.getParent())){
			value = findCategory.getParent();
			path = getBreadCrumb(">"+path, value ,value , mongoOperation);
		}
		
		return path;
		
		/*path = value+path;
		Query searchUserQuery = new Query(Criteria.where("id").is(value));
		Category findCategory = mongoOperation.findOne(searchUserQuery, Category.class);
		if(!"0".equals(findCategory.getParent())){
			value = findCategory.getParent();
			path = getBreadCrumb(">"+path, value , mongoOperation);
		}
		
		return path;*/
	}
	
	private static List<Category> getChild( String value, MongoOperations mongoOperation,String tab){
		
		//FOR LEVEL
		
		//if("\t\t\t".equals(tab))
			//return null;
		
		Query searchUserQuery = new Query(Criteria.where("parent").is(value));
		List<Category> findCategory = mongoOperation.find(searchUserQuery, Category.class);
		
		if(findCategory != null){
			
			for (Category category : findCategory) {
				//System.out.println(tab+category.getId());
					if(category.getSomeadditionalattr()!=null){
						//System.out.println(tab+category.getSomeadditionalattr());
						//print breadcrumb
						String path = getBreadCrumb("", category.getId(),category.getId(), mongoOperation);
						
						// update password
						
						Query searchQuery = new Query(Criteria.where("id").is(category.getId()));
						mongoOperation.updateFirst(searchQuery, Update.update("breadcrumb", path),Category.class);
						
						
						
						//System.out.println(tab+ path );
					}else{
						category.setChildren(getChild(category.getId(),  mongoOperation,tab+"\t"));
					}
				
			}
			
		}
		return findCategory;
	}

}