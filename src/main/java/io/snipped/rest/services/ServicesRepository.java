package io.snipped.rest.services;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ServicesRepository extends MongoRepository<Services, String>{
	public List<Services> findByCategory(String category);
	public List<Services> findByCategoryAndGender(String category, String gender);
}
