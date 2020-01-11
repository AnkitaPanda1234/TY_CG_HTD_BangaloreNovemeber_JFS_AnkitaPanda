package com.capgemini.retailermaintenancesystemapplicationdevelopment.config.controller.dto;

import java.util.List;

public class OrderResponse {
	 private int statusCode;
     private String message;
     private String description;
     private List<OrderBean> beans;
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
	public List<OrderBean> getBeans() {
		return beans;
	}
	public void setBeans(List<OrderBean> beans) {
		this.beans = beans;
	}
     

}
