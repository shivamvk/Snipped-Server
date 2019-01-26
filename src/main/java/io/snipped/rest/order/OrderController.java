package io.snipped.rest.order;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.snipped.rest.response.Response;

@RestController
public class OrderController {

	@Autowired
	private OrderService service;
	
	@PostMapping(value="/order")
	public Response insert(
			@RequestParam String phone,
			@RequestParam String services,
			@RequestParam int amount,
			@RequestParam String address,
			@RequestParam String date,
			@RequestParam String time,
			@RequestParam String appointmentDate,
			@RequestParam String appointmentTime,
			@RequestParam String status,
			@RequestParam String remarks) {
		service.insert(new Order(
				ObjectId.get(),
				phone,
				services,
				amount,
				address,
				date,
				time,
				appointmentDate,
				appointmentTime,
				status,
				remarks
			));
		List<Object> list = new ArrayList<>(); 
		return new Response(200, list, "Okay from shivamvk");
	}
	
	@GetMapping(value="/order")
	public Response getOrderByUser(@RequestParam String phone) {
		List<Order> list = service.getByUserId(phone);
		List<Object> responseList = new ArrayList<>();
		for(int i=0; i<list.size(); i++) {
			responseList.add(list.get(i));
		}
		return new Response(200, responseList, "Okay from shivamvk");
	}
}
