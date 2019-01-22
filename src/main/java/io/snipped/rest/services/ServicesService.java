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
}
