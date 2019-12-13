package com.cap.phonesimulator.bean;

public class ContactBean {
	private String name;
	private int number;
	private String group_info;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getGroup_info() {
		return group_info;
	}
	public void setGroup_info(String group_info) {
		this.group_info = group_info;
	}
	@Override
	public String toString() {
		return "ContactBean [name=" + name + ", number=" + number + ", group_info=" + group_info + "]";
	}
	

}
