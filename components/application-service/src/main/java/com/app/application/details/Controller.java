package com.app.application.details;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/application")
//@CrossOrigin(origins = "*", allowedHeaders = "*")
public class Controller {

	@Autowired
	private AService applicationService;

	//@Cacheable(value = "application", key = "#id")
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public AModel get(@PathVariable(name = "id") String id) {
		
		System.out.println("inside get application name");
		return applicationService.findOne(id);
	}

	@RequestMapping(method = RequestMethod.GET)
	public List<AModel> get() {
		
		System.out.println("inside get all application name");
		return applicationService.findAll();
	}
	
	//@CachePut(value = "application", key = "#application.id")
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public AModel save(@RequestBody AModel application) {
		
		System.out.println( "inside save method");
		return applicationService.save(application);
	}
	//@CacheEvict(value = "application", key = "#id")
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public void delete(@PathVariable(name = "id") String id) {
		applicationService.delete(id);
	}
}

