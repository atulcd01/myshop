package core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;

import com.app.application.details.AModel;

import config.SpringMongoConfig;


public class Main {
	
	public static void main(String [] arg) throws Exception{
		ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringMongoConfig.class);
		MongoOperations mongoOperation = (MongoOperations) ctx.getBean("mongoTemplate");

		//mongoOperation.dropCollection(AModel.class);
	        	      
      setApplicationName(mongoOperation );
	}
	
	private static void  setApplicationName(MongoOperations mongoOperation ){
		AModel a = new AModel("1","The Cake Room");
		mongoOperation.save(a);
	}




}
