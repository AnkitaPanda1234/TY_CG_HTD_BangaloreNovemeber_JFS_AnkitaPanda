package com.capgemini.forestrymanagementsystembyusingcollection.baen;

public class ClientBean {
	private int id;
	private String clientUserName;
	private String clientPassword;
	private String role;

	public String getClientUserName() {
		return clientUserName;
	}

	public void setClientUserName(String clientUserName) {
		this.clientUserName = clientUserName;
	}

	public String getClientPassword() {
		return clientPassword;
	}

	public void setClientPassword(String clientPassword) {
		this.clientPassword = clientPassword;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "Client Details are as Below: \n" + "Id=" + id + ", User Name=" + clientUserName + ", Password="
				+ clientPassword + ", Role=" + role;
	}

}
