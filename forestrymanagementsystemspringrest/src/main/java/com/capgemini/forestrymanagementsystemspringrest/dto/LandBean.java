package com.capgemini.forestrymanagementsystemspringrest.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name="land_info")
public class LandBean implements Serializable {
	@Id
	@Column
	@GeneratedValue
	private int landid;
	@Column
	private String landLocation;
	@Column
	private long landValue;
	@Column
	private String realisedDate;

	public int getLandid() {
		return landid;
	}
	/**
	 * @param landid the landid to set
	 */
	public void setLandid(int landid) {
		this.landid = landid;
	}
	
	public String getLandLocation() {
		return landLocation;
	}
	
	public void setLandLocation(String landLocation) {
		this.landLocation = landLocation;
	}
	
	public long getLandValue() {
		return landValue;
	}
	
	public void setLandValue(long landValue) {
		this.landValue = landValue;
	}
	
	public String getRealisedDate() {
		return realisedDate;
	}
	
	public void setRealisedDate(String realisedDate) {
		this.realisedDate = realisedDate;
	}
	@Override
	public String toString() {
		return "LandBean [landid=" + landid + ", landLocation=" + landLocation + ", landValue=" + landValue
				+ ", realisedDate=" + realisedDate + "]";
	}



}
