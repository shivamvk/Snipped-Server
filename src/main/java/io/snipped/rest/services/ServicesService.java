package io.snipped.rest.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicesService {

	@Autowired
	private ServicesRepository repository;
	
	public Services insert(Services service) {
		repository.insert(service);
		return service;
	}
	
	public List<Services> getAllServices(){
		return repository.findAll();
	}
	
	public List<Services> getServiceByCategory(String category){
		return repository.findByCategory(category);
	}
	
	public Services getServiceById(String id) {
		return repository.findById(id).get();
	}
	
	public List<Services> getServiceByCategoryAndGender(String category, String gender){
		return repository.findByCategoryAndGender(category, gender);
	}
}
