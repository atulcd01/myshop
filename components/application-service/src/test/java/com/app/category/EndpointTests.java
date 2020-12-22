package com.app.category;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.app.application.details.AModel;
import com.app.application.details.AMongoRepository;
import com.app.application.details.ApplicationProperties;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


//@RunWith(SpringRunner.class)
@SpringBootTest(classes=ApplicationProperties.class,webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class EndpointTests {/*
    
    final String BASE_PATH = "http://localhost:9999/application";

	@Autowired
	private AMongoRepository repository;
	
    private RestTemplate restTemplate  = new RestTemplate();;
    
    private ObjectMapper MAPPER = new ObjectMapper();
    
    @Before
    public  void setUp() throws Exception {
        repository.deleteAll();

        repository.save(new AModel("1", "The Cake Shop"));
        repository.save(new AModel("2", "The Wine Shop"));
        repository.save(new AModel("3", "Flipkart"));
		repository.save(new AModel("4", "Flipkart"));
		repository.save(new AModel("5", "Amazon"));        
       
		System.out.println(" inside before ");
        restTemplate = new RestTemplate();
    }
    
    @Test
    public void testSave() throws JsonProcessingException{
        //restTemplate.delete(BASE_PATH + "/save");
        AModel model = new AModel("6", "Costa");
        AModel response = restTemplate.postForObject(BASE_PATH + "/save", model, AModel.class);
        assertEquals("Costa", response.getName());
    }
    
    
    @Test
    public void testGetAll() throws JsonProcessingException{
        //restTemplate.delete(BASE_PATH + "/save");

        AModel[] response = restTemplate.getForObject(BASE_PATH,  AModel[].class);
        assertTrue(response.length==5);
    	String response = restTemplate.getForObject(BASE_PATH + "/findAll", String.class);
        List<AModel> object = MAPPER.readValue(response, MAPPER.getTypeFactory().constructCollectionType(List.class, AModel.class));
        assertTrue(object.size()==5);
    }
    
	    @Test
	    public void testGet() throws JsonProcessingException{
	        //restTemplate.delete(BASE_PATH + "/save");
	
	        AModel response = restTemplate.getForObject(BASE_PATH + "/1",  AModel.class);
	        assertEquals("The Cake Shop",response.getName());
	    }
	    
	    
	    @Test
	    public void testGetNegative() throws JsonProcessingException{
	        //restTemplate.delete(BASE_PATH + "/save");
	
	        AModel response = restTemplate.getForObject(BASE_PATH + "/2",  AModel.class);
	        assertNotEquals("Flipkart",response.getName());
	    }
    
  */}