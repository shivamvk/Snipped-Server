package io.snipped.rest.order;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.snipped.rest.response.Response;
import io.snipped.rest.services.Services;
import io.snipped.rest.services.ServicesRepository;

@RestController
public class OrderController {

	@Autowired
	private OrderService service;
	
	@Autowired 
	private ServicesRepository repository;
	
	@PostMapping(value="/order")
	public Response insert(
			@RequestParam String phone,
			@RequestParam String services,
			@RequestParam String amount,
			@RequestParam String address,
			@RequestParam String date,
			@RequestParam String time,
			@RequestParam String appointmentDate,
			@RequestParam String appointmentTime,
			@RequestParam String status,
			@RequestParam String remarks,
			@RequestParam String coupon) {
		
		List<Services> servicesList = getServices(services);
		
		Order order = new Order(
				ObjectId.get(),
				phone,
				servicesList,
				amount,
				address,
				date,
				time,
				appointmentDate,
				appointmentTime,
				status,
				remarks,
				coupon
			);
		service.insert(order);
		List<Object> list = new ArrayList<>();
		list.add(order);
		return new Response(200, list, "Okay from shivamvk");
	}
	
	@GetMapping(value="/order/{phone}")
	public Response getOrderByUser(@PathVariable String phone) {
		List<Order> list = service.getByUserId(phone);
		List<Object> responseList = new ArrayList<>();
		for(int i=0; i<list.size(); i++) {
			responseList.add(list.get(i));
		}
		return new Response(200, responseList, "Okay from shivamvk");
	}
	
	@GetMapping(value="order/{phone}/status/{status}")
	public Response getOrderByUSerByStatus(
			@PathVariable String phone,
			@PathVariable String status) {
		List<Order> list = service.getByUserAndStatus(phone, status);
		List<Object> responseList = new ArrayList<>();
		for(int i=0; i<list.size(); i++) {
			responseList.add(list.get(i));
		}
		return new Response(200, responseList, "Okay from shivamvk");
	}
	
	@GetMapping(value="order/{phone}/date/{date}")
	public Response getOrderByUserByDate(
			@PathVariable String phone,
			@PathVariable String date) {
		List<Order> list = service.getByUserAndStatus(phone, date);
		List<Object> responseList = new ArrayList<>();
		for(int i=0; i<list.size(); i++) {
			responseList.add(list.get(i));
		}
		return new Response(200, responseList, "Okay from shivamvk");
	}
	
	@GetMapping(value="/order/date/{date}")
	public Response getOrderByDate(@PathVariable String date) {
		List<Order> list = service.getByAppointmentDate(date);
		List<Object> responseList = new ArrayList<>();
		for(int i=0; i<list.size(); i++) {
			responseList.add(list.get(i));
		}
		return new Response(200, responseList, "Okay from shivamvk");
	}
	
	@GetMapping(value="/order/cancel/{id}")
	public String cancelOrderById(@PathVariable String id) {
		Order order = service.getById(id);
		order.setStatus("Cancelled");
		service.deleteById(id);
		service.insert(order);
		return "Okay from shivamvk";
	}
	
	@GetMapping(value="/trending")
	public Response getTrending() {
		List<Order> list = service.getAll();
		Set<Services> set = new LinkedHashSet<>();
		for(int i=0; i<list.size(); i++) {
			List<Services> services = list.get(i).services;
			set.addAll(services);
			if(set.size() >= 10) {
				break;
			}
		}
		List<Object> responseList = new ArrayList<>();
		for(Services s : set) {
			responseList.add(s);
		}
		return new Response(200, responseList, "Okay from shivamvk");
	}
	
	List<Services> getServices(String services){
		String[] servicesList = services.split(",");
		List<Services> list = new ArrayList<>();
		for(int i=0; i<servicesList.length; i++) {
			if(servicesList[i].length() > 1) {
				list.add(repository.findById(servicesList[i]).get());
			}
		}
		return list;
	}
}
