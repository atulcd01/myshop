package com.app.ecom.cart;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Swagger2UiConfiguration extends WebMvcConfigurerAdapter  {
	 @Bean
	   public Docket api(){
	      return new Docket(DocumentationType.SWAGGER_2)
	    	  .apiInfo(getApiInfo())	  
	    	  .select()
	          .apis(RequestHandlerSelectors.basePackage("com"))
	          .paths(PathSelectors.any())
	          .build();
	   }
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
		registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
	}
	private ApiInfo getApiInfo() {
		   return new ApiInfo("Application Data Api Documentation",
		      "Subject Api Documentation", 
		      "1.0", 
		      "urn:tos",
		       new Contact("", "", ""), 
	              "Apache 2.0", "http://www.apache.org/licenses/LICENSE-2.0", 
	              new ArrayList<VendorExtension>());
	   }  


}
