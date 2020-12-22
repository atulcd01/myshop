package com.app.application.details;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class AService {

	@Autowired
	private AMongoRepository applicationRepository;

	
	public  AModel save(AModel application){
		System.out.println( "inside save service  method" +application.getName());
		return applicationRepository.save(application);
	}

	public AModel findOne(String id) {

		return applicationRepository.findById(id).orElse(null);
	}
	
	public List<AModel> findAll() {

		return applicationRepository.findAll();
	}

	public void delete(String id) {
		
		applicationRepository.deleteById(id);
		
	}
	
}
