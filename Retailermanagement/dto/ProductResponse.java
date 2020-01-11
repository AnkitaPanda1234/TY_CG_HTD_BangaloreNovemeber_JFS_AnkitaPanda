package com.capgemini.retailermaintenancesystemapplicationdevelopment.config.controller.dto;

import java.util.List;

public class ProductResponse {
	 private int statusCode;
     private String message;
     private String description;
     private List<ProductBean> beans;
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
	public List<ProductBean> getBeans() {
		return beans;
	}
	public void setBeans(List<ProductBean> beans) {
		this.beans = beans;
	}
     
     

}
