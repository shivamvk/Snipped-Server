package io.snipped.rest.user;

import org.springframework.data.annotation.Id;

public class User {
	@Id
	String phone;
	String name;
	String email;
	
	public User(String phone, String name, String email) {
		super();
		this.phone = phone;
		this.name = name;
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getUsername() {
		return name;
	}

	public void setUsername(String username) {
		this.name = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
