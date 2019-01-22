package io.snipped.rest.services;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

public class Services {

	@Id
	ObjectId _id;
	
	String name;
	int price;
	String category;
	String subcategory;
	
	public Services(ObjectId _id, String name, int price, String category, String subcategory) {
		super();
		this._id = _id;
		this.name = name;
		this.price = price;
		this.category = category;
		this.subcategory = subcategory;
	}
	
	public String get_id() {
		return _id.toHexString();
	}
	
	public void set_id(ObjectId _id) {
		this._id = _id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getSubcategory() {
		return subcategory;
	}

	public void setSubcategory(String subcategory) {
		this.subcategory = subcategory;
	}
	
}
