package com.capgemini.forestrymanagementsystemspringrest.dto;

import java.util.List;

public class CustomerResponse {
	 private int statusCode;
     private String message;
     private String description;
     
     private List<CustomerBean> beans;
     
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<CustomerBean> getBeans() {
		return beans;
	}
	public void setBeans(List<CustomerBean> beans) {
		this.beans = beans;
	}

}
