package com.capgemini.forestrymanagementsystemspringrest.dto;

import java.util.List;

public class LandResponse {
	private int statusCode;
    private String message;
    private String description;
    
    private List<LandBean> beans;

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

	public List<LandBean> getBeans() {
		return beans;
	}

	public void setBeans(List<LandBean> beans) {
		this.beans = beans;
	}

	
    
}
