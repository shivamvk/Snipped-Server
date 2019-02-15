package io.snipped.rest.address;

import org.bson.types.ObjectId;

public class Address {
	
	private ObjectId _id;
	private String user;
	private String pincode;
	private String flat;
	private String colony;
	private String city;
	
	public Address(ObjectId _id, String user, String pincode, String flat, String colony, String city) {
		super();
		this._id = _id;
		this.user = user;
		this.pincode = pincode;
		this.flat = flat;
		this.colony = colony;
		this.city = city;
	}
	
	public String get_id() {
		return _id.toHexString();
	}
	
	public void set_id(ObjectId _id) {
		this._id = _id;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getFlat() {
		return flat;
	}

	public void setFlat(String flat) {
		this.flat = flat;
	}

	public String getColony() {
		return colony;
	}

	public void setColony(String colony) {
		this.colony = colony;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

}
