package com.capgemini.forestrymanagementsystembyusingcollection.baen;

public class SchedulerBean {
	private int id;
	private String UserName;
	private String Password;
	private String role;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return UserName;
	}

	public void setUserName(String userName) {
		UserName = userName;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "Scheduler details are as Below :/n" + "  id=" + id + ", UserName=" + UserName + ", Password=" + Password
				+ ", role=" + role + "";
	}

}
