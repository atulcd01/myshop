package config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;

import com.mongodb.MongoClient;

@Configuration
public class SpringMongoConfig extends AbstractMongoConfiguration {

	@Override
	public String getDatabaseName() {
		return "catalogdb";
	}


	@Override
	public MongoClient mongoClient() {
		// TODO Auto-generated method stub
		return new MongoClient("localhost");
	}
}