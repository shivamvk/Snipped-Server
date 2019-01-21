package io.snipped.rest.slider;

import org.springframework.data.annotation.Id;

public class Slider {
	
	@Id
	int id;
	String url;
	
	public Slider(int id, String url) {
		super();
		this.id = id;
		this.url = url;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
}
