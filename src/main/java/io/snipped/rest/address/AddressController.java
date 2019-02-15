package io.snipped.rest.address;

import java.util.ArrayList;
import java.util.List;

import io.snipped.rest.response.Response;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddressController {

	@Autowired
	private AddressService service;
	
	@PostMapping(value="/address")
	public String insert(
				@RequestParam String user,
				@RequestParam String pincode,
				@RequestParam String flat,
				@RequestParam String colony,
				@RequestParam String city
			) {
		service.insert(new Address(
				ObjectId.get(),
				user,
				pincode,
				flat,
				colony,
				city
			));
		return "okay from shivamvk";
	}
	
	@GetMapping(value="/address/{user}")
	public Response getAddress(@PathVariable String user){
		List<Address> list = service.getListByUser(user);
		List<Object> responseList = new ArrayList<>();
		responseList.addAll(list);
		return new Response(200, responseList, "okay from shivamvk");
	}
	
}
