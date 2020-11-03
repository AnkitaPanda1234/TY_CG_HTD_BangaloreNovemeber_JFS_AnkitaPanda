package com.capgemini.forestrymanagementsystemspringrest.dto;

import java.util.List;

public class ScheduleResponse {
	private int statusCode;
	private String message;
	private String description;
	private List<ScheduleBean> beans;

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

	public List<ScheduleBean> getBeans() {
		return beans;
	}

	public void setBeans(List<ScheduleBean> beans) {
		this.beans = beans;
	}

	@Override
	public String toString() {
		return "Schedule Response [statusCode=" + statusCode + ", message=" + message + ", description=" + description
				+ ", beans=" + beans + "]";
	}

}
