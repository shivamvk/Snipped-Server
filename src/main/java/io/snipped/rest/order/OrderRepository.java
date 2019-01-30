package io.snipped.rest.order;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderRepository extends MongoRepository<Order, String>{
	public List<Order> findByPhone(String phone);
	public List<Order> findByAppointmentDate(String date);
	public List<Order> findByPhoneAndStatus(String phone, String status);
	public List<Order> findByPhoneAndAppointmentDate(String phone, String appointmentDate);
}
