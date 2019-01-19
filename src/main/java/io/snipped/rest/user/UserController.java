package io.snipped.rest.user;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.snipped.rest.response.Response;

@RestController
public class UserController {

	@Autowired
	private UserService service;
	
	@PostMapping("/user")
	public boolean insertUser(@RequestParam String email, 
			@RequestParam String name, 
			@RequestParam String phone) {
		return service.insert(new User(phone, name, email));
	}
	
	@GetMapping("/number_exists")
	public boolean doesNumberExists(@RequestParam String phone) {
		return service.numberExists(phone);
	}
	
	@GetMapping("/user/{phone}")
	public Response getUserByPhone(@PathVariable String phone) {
		User user = service.getUserById(phone);
		List<Object> responseList = new ArrayList<>();
		responseList.add(user);
		Response response = new Response(200, responseList, "Okay");
		return response;
	}
	
	@GetMapping("/user")
	public Response getAllUsers() {
		List<User> list = service.getAllUsers();
		List<Object> responseList = new ArrayList<>();
		for(int i=0; i<list.size(); i++) {
			responseList.add(list.get(i));
		}
		Response response = new Response(200, responseList, "Okay");
		return response;
	
	}
	
}
