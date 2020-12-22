package core;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.app.ecom.category.Category;

import config.SpringMongoConfig;


public class Main {
	
	public static void main(String [] arg) throws Exception{
		ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringMongoConfig.class);
		MongoOperations mongoOperation = (MongoOperations) ctx.getBean("mongoTemplate");

		//mongoOperation.dropCollection(Category.class);
		// save createSampleData
		String baseid = null;
		 Pattern patt = Pattern.compile("\"([^\"]*)\"");
		 FileReader fileReader = new FileReader("D:/work/desktop_documents/cakeshop.csv");
		
	        BufferedReader r = new BufferedReader(fileReader);
	      
	        String line;
	        HashMap hm = new HashMap();
	        ArrayList headerSpecifications = new ArrayList();
	        int i=1;
	        	        while ((line = r.readLine()) != null) {

	        	        	
	        	        	Matcher m = patt.matcher(line);

	        	        	boolean flg = false;
	        	        	if(i==1)
	        	        	{
	        	        		
	        	        		
		        	        		String[] c= line.split(",");
		        	        		int j = 0;
		        	        		for (String string : c) {
		        	        			if( j >= 8 )
		        	        				headerSpecifications.add(c[j]);
		        	        			j++;
									}
		        	        		headerSpecifications.remove(headerSpecifications.size()-1);
		        	        		System.out.println(headerSpecifications);
	        	        		i++;
	        	        		continue;
	        	        	}
	        	        	//this run pny
	        	        	while (m.find()) {
	        	        		String productids = m.group(0);
	        	        		//System.out.println(productids);
	        	        			        	        		//System.out.println(productids.replaceAll(",", "~"));
	        	        		line = line.replaceAll(productids, productids.replaceAll(",", "~"));
	        	        		String[] c= line.split(",");
	        	        		flg = true;
	        	        		mongoOperation.remove(new Category(c[0]));
	        	        		//System.out.println(c[0]);
	        	        		//putting application id 
	        	        		if(i==2){
	        	        			
	        	        		}

	        	        		mongoOperation.save(new Category(c[0],c[1], c[2], Integer.valueOf(c[3]).intValue(), c[4], c[5], c[6], c[7].replaceAll("\"", "").split("~"),c,headerSpecifications,baseid));
	        	        	}
	        	        	
	        	        	if(!flg){
	        	        		
	        	        		
	        	        		String[] c= line.split(",");
	        	        		
	        	        		mongoOperation.remove(new Category(c[0]));
	        	        		if(baseid==null)
	        	        		baseid = c[2];
	        	        		if(c.length>4)
	        	        			mongoOperation.save(new Category(c[0],c[1], c[2], Integer.valueOf(c[3]).intValue(), c[4], c[5], c[6],null ,c,headerSpecifications,baseid));
	        	        		else
	        	        			mongoOperation.save(new Category(c[0],c[1], c[2], Integer.valueOf(c[3]).intValue(), null, null, null,baseid));
	        	        	}
	        	        	//System.out.println(line);
	        	        }
	        	        
	        	      getChild("cakeshop",  mongoOperation,null,baseid);
	        			//getItem("cakeshop", mongoOperation);
	        	      
	        	      //setApplicationName(mongoOperation );
	}
	
	/*private static void  setApplicationName(MongoOperations mongoOperation ){
		AModel a = new AModel("1","The Cake Room");
		mongoOperation.save(a);
	}*/
private static List<Category> getChild( String value, MongoOperations mongoOperation,String tab,String baseid){
		
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
						String path = getBreadCrumb("", category.getId(),category.getName(), mongoOperation,baseid);
						
						// update password
						
						Query searchQuery = new Query(Criteria.where("id").is(category.getId()));
						mongoOperation.updateFirst(searchQuery, Update.update("breadcrumb", path),Category.class);
						
						
						
						//System.out.println(tab+ path );
					}else{
						category.setChildren(getChild(category.getId(),  mongoOperation,tab+"\t",baseid));
					}
				
			}
			
		}
		return findCategory;
	}
public static  String getBreadCrumb(String path,String value,String name,MongoOperations mongoOperation,String baseid){
	

	//path = value+path;
	 path = "<div class=\"_1HEvv0\"><a class=\"_1KHd47\"  href=\"/protected/products/"+value+"?a="+baseid+"\"  >"+name+"</a></div>"+path;
	 

	 Query searchUserQuery = new Query(Criteria.where("id").is(value));
	 Category findCategory = mongoOperation.findOne(searchUserQuery, Category.class);
	if(findCategory!=null){ //!"0".equals(findCategory.getParent())
		value = findCategory.getParent();
		path = getBreadCrumb("<svg width=\"16\" height=\"27\" viewBox=\"0 0 16 27\" xmlns=\"http://www.w3.org/2000/svg\" class=\"_2XP0B_\"><path d=\"M16 23.207L6.11 13.161 16 3.093 12.955 0 0 13.161l12.955 13.161z\" fill=\"#fff\" class=\"_24NaUy\"></path></svg>"+path, findCategory.getParent() , findCategory.getName(),mongoOperation ,baseid);
	}
	
	return path;

	
}



}
