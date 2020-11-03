package com.capgemini.forestrymanagementsystembyusingcollection.baen;

public class HauilerBean {

	private int hauilerid;
	private String hauilername;
	private String email;
	private long contactnum;
	private String streetAddress1;
	private String streetAddress2;
	private String town;
	private int postalCode;
	public int getHauilerid() {
		return hauilerid;
	}
	public void setHauilerid(int hauilerid) {
		this.hauilerid = hauilerid;
	}
	public String getHauilername() {
		return hauilername;
	}
	public void setHauilername(String hauilername) {
		this.hauilername = hauilername;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public long getContactnum() {
		return contactnum;
	}
	public void setContactnum(long contactnum) {
		this.contactnum = contactnum;
	}
	public String getStreetAddress1() {
		return streetAddress1;
	}
	public void setStreetAddress1(String streetAddress1) {
		this.streetAddress1 = streetAddress1;
	}

	public String getStreetAddress2() {
		return streetAddress2;
	}
	public void setStreetAddress2(String streetAddress2) {
		this.streetAddress2 = streetAddress2;
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
	@Override
	public String toString() {
		return "HauilerDetails are as Below: /n"
				+ " hauilerid=" + hauilerid + ", hauilername=" + hauilername + ", email=" + email
				+ ", contactnum=" + contactnum + ", streetAddress1=" + streetAddress1 + ", streetAddress2="
				+ streetAddress2 + ", town=" + town + ", postalCode=" + postalCode + "";
	}

}
