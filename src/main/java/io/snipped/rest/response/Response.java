package io.snipped.rest.response;

import java.util.List;

public class Response {

	private int status;
	private List<Object> data;
	private String message;
	
	public Response(int status, List<Object> data, String message) {
		super();
		this.status = status;
		this.data = data;
		this.message = message;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public List<Object> getData() {
		return data;
	}

	public void setData(List<Object> data) {
		this.data = data;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
