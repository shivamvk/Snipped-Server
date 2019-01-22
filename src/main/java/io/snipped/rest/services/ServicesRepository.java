package io.snipped.rest.services;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ServicesRepository extends MongoRepository<Services, String>{
	
}
