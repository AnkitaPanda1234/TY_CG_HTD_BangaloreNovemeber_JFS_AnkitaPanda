package com.capgemini.forestrymanagementsystemspringrest.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name="customer")
public class CustomerBean implements Serializable {
	@Id
	@Column
	@GeneratedValue
	private int customerid;
	@Column
	private String customerName;
	@Column
	private String streetAddress1;
	@Column
	private String town;
	@Column
	private int postalCode;
	@Column
	private String email;
	@Column
	private long telephoneNum;

	public int getCustomerid() {
		return customerid;
	}

	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getStreetAddress1() {
		return streetAddress1;
	}

	public void setStreetAddress1(String streetAddress1) {
		this.streetAddress1 = streetAddress1;
	}

	public String getTown() {
		return town;
	}

	public void setTown(String town) {
		this.town = town;
	}

	public int getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(int postalCode) {
		this.postalCode = postalCode;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getTelephoneNum() {
		return telephoneNum;
	}

	public void setTelephoneNum(long telephoneNum) {
		this.telephoneNum = telephoneNum;
	}

	@Override
	public String toString() {
		return "Customer Details : \n"
				+ " customerid=" + customerid + ", customerName=" + customerName + ", streetAddress1="
				+ streetAddress1 + ", town=" + town + ", postalCode=" + postalCode + ", email=" + email
				+ ", telephoneNum=" + telephoneNum + "]";
	}

	
	

}
