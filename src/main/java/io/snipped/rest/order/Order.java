package io.snipped.rest.order;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

import io.snipped.rest.services.Services;

public class Order {

	@Id
	ObjectId _id;
	String phone;
	List<Services> services;
	String amount;
	String address;
	String date;
	String time;
	String appointmentDate;
	String appointmentTime;
	String status;
	String remarks;
	String coupon;
	
	public Order(ObjectId _id, String phone, List<Services> services, String amount, String address, String date,
			String time, String appointmentDate, String appointmentTime, String status, String remarks, String coupon) {
		super();
		this._id = _id;
		this.phone = phone;
		this.services = services;
		this.amount = amount;
		this.address = address;
		this.date = date;
		this.time = time;
		this.appointmentDate = appointmentDate;
		this.appointmentTime = appointmentTime;
		this.status = status;
		this.remarks = remarks;
		this.coupon = coupon;
	}

	public String get_id() {
		return _id.toHexString();
	}

	public void set_id(ObjectId _id) {
		this._id = _id;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public List<Services> getServices() {
		return services;
	}

	public void setServices(List<Services> services) {
		this.services = services;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getAppointmentDate() {
		return appointmentDate;
	}

	public void setAppointmentDate(String appointmentDate) {
		this.appointmentDate = appointmentDate;
	}

	public String getAppointmentTime() {
		return appointmentTime;
	}

	public void setAppointmentTime(String appointmentTime) {
		this.appointmentTime = appointmentTime;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
	public String getCoupon() {
		return coupon;
	}
	
	public void setCoupon(String coupon) {
		this.coupon = coupon;
	}
	
}
