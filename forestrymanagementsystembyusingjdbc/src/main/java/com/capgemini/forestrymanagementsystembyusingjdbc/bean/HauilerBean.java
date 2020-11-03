package com.capgemini.forestrymanagementsystembyusingjdbc.bean;

import java.io.Serializable;

/**
 * 
 * @author Ankita Panda
 *
 */
@SuppressWarnings("serial")
public class HauilerBean implements Serializable {

	private int hauilerid;
	private String hauilername;
	private String email;
	private long contactnum;
	private String streetAddress1;
	private String streetAddress2;
	private String town;
	private int postalCode;

	/**
	 * @return the hauilerid
	 */
	public int getHauilerid() {
		return hauilerid;
	}

	/**
	 * @param hauilerid
	 *            the hauilerid to set
	 */
	public void setHauilerid(int hauilerid) {
		this.hauilerid = hauilerid;
	}

	/**
	 * @return the hauilername
	 */
	public String getHauilername() {
		return hauilername;
	}

	/**
	 * @param hauilername
	 *            the hauilername to set
	 */
	public void setHauilername(String hauilername) {
		this.hauilername = hauilername;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the contactnum
	 */
	public long getContactnum() {
		return contactnum;
	}

	/**
	 * @param contactnum
	 *            the contactnum to set
	 */
	public void setContactnum(long contactnum) {
		this.contactnum = contactnum;
	}

	/**
	 * @return the streetAddress1
	 */
	public String getStreetAddress1() {
		return streetAddress1;
	}

	/**
	 * @param streetAddress1
	 *            the streetAddress1 to set
	 */
	public void setStreetAddress1(String streetAddress1) {
		this.streetAddress1 = streetAddress1;
	}

	/**
	 * @return the streetAddress2
	 */
	public String getStreetAddress2() {
		return streetAddress2;
	}

	/**
	 * @param streetAddress2
	 *            the streetAddress2 to set
	 */
	public void setStreetAddress2(String streetAddress2) {
		this.streetAddress2 = streetAddress2;
	}

	/**
	 * @return the town
	 */
	public String getTown() {
		return town;
	}

	/**
	 * @param town
	 *            the town to set
	 */
	public void setTown(String town) {
		this.town = town;
	}

	/**
	 * @return the postalCode
	 */
	public int getPostalCode() {
		return postalCode;
	}

	/**
	 * @param postalCode
	 *            the postalCode to set
	 */
	public void setPostalCode(int postalCode) {
		this.postalCode = postalCode;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "HauilerBean [hauilerid=" + hauilerid + ", hauilername=" + hauilername + ", email=" + email
				+ ", contactnum=" + contactnum + ", streetAddress1=" + streetAddress1 + ", streetAddress2="
				+ streetAddress2 + ", town=" + town + ", postalCode=" + postalCode + "]";
	}

}
