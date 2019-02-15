package io.snipped.rest.address;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {
	
	@Autowired
	private AddressRepository repo;
	
	public void insert(Address address) {
		repo.insert(address);
	}
	
	public List<Address> getListByUser(String user){
		return repo.findByUser(user);
	}
	
}
