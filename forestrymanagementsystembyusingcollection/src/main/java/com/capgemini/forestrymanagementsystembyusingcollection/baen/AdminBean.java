package com.capgemini.forestrymanagementsystembyusingcollection.baen;

public class AdminBean {
	private int id;
	private String username;
	private String userpassword;
	private String role;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserpassword() {
		return userpassword;
	}

	public void setUserpassword(String userpassword) {
		this.userpassword = userpassword;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "AdminBean [id=" + id + ", username=" + username + ", userpassword=" + userpassword + ", role=" + role
				+ "]";
	}

}
