package io.snipped.rest.services;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.snipped.rest.response.Response;

@RestController
public class ServicesController {

	@Autowired
	private ServicesService service;
	
	@PostMapping(value="/service/{category}/{subcategory}")
	public Response insertService(@RequestParam String name,
			@RequestParam int price,
			@PathVariable String category,
			@PathVariable String subcategory,
			@RequestParam String gender) {
		Services services = new Services(ObjectId.get(), name, price, category, subcategory, gender);
		service.insert(services);
		List<Object> responseList = new ArrayList<>();
		responseList.add(services);
		Response response = new Response(200, responseList, "Okay from shivamvk");
		return response;
	}
	
	@GetMapping(value="/service")
	public Response getAllServices() {
		List<Services> list = service.getAllServices();
		List<Object> responseList = new ArrayList<>();
		for(int i=0; i<list.size(); i++) {
			responseList.add(list.get(i));
		}
		Response response = new Response(200, responseList, "Okay from shivamvk");
		return response;
	}
	
	@GetMapping(value="/service/{category}")
	public Response getServicesByCategory(@PathVariable String category) {
		List<Services> list = service.getServiceByCategory(category);
		List<Object> responseList = new ArrayList<>();
		for(int i=0; i<list.size(); i++) {
			responseList.add(list.get(i));
		}
		Response response = new Response(200, responseList, "Okay from shivamvk");
		return response;
	}
	
	@GetMapping(value="/service/id/{idstring}")
	public Response getServicesById(@PathVariable String idstring) {
		String[] array = idstring.split(",");
		List<String> list = new ArrayList<>();
		for(int i=0; i<array.length; i++) {
			if(array[i].length() > 1) {
				list.add(array[i]);
			}
		}
		List<Object> responseList = new ArrayList<>();
		for(int i=0; i<list.size(); i++) {
			responseList.add(service.getServiceById(list.get(i)));
		}
		Response response = new Response(200, responseList, "Okay from shivamvk");
		return response;
	}
	
	
	
	
	
	
	
}
