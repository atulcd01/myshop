package com.ecomm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@ServletComponentScan
@SpringBootApplication
//@ComponentScan(basePackages = "com.ecomm.*")
//@Import({ WebConfig.class,TilesConfiguration.class,PersistenceJPAConfig.class,SecurityConfig.class})

@EnableJpaRepositories("com.ecomm.repository.jpa.**")
@EnableTransactionManagement
@EntityScan("com.ecomm.model")


public class ShopApplication extends SpringBootServletInitializer {
	
	 private static Class applicationClass = ShopApplication.class;

    public static void main(String[] args) {
        SpringApplication.run(ShopApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(applicationClass);
    }

} 