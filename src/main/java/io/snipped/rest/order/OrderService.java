package io.snipped.rest.order;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

	@Autowired
	private OrderRepository repository;
	
	public void insert(Order order) {
		repository.insert(order);
	}
	
	public List<Order> getAll() {
		return repository.findAll();
	}
	
	public Order getById(String id) {
		return repository.findById(id).get();
	}
	
	public List<Order> getByUserId(String phone){
		return repository.findByPhone(phone);
	}
	
	public List<Order> getByAppointmentDate(String date){
		return repository.findByAppointmentDate(date);
	}
	
	public List<Order> getByUserAndStatus(String phone, String status){
		return repository.findByPhoneAndStatus(phone, status);
	}
	
	public List<Order> getByUserAndDate(String phone, String appointmentDate){
		return repository.findByPhoneAndAppointmentDate(phone, appointmentDate);
	}
	
	public void deleteById(String id) {
		repository.deleteById(id);
	}
}
