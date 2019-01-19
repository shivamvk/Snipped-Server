package io.snipped.rest.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	public boolean insert(User user) {
		repository.insert(user);
		return true;
	}
	
	public List<User> getAllUsers(){
		return repository.findAll();
	}
	
	public User getUserById(String phone) {
		return repository.findById(phone).get();
	}
	
	public boolean numberExists(String phone) {
		return localNumberExists(phone);
	}
	
	private boolean localNumberExists(String phone) {
		boolean bool = false;
		List<User> list =repository.findAll();
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).getPhone().equals(phone)) {
				bool = true;
			}
		}
		return bool;
	}

}
