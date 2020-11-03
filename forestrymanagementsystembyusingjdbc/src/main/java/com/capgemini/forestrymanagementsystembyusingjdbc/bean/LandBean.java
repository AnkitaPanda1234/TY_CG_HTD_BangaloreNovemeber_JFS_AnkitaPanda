package com.capgemini.forestrymanagementsystembyusingjdbc.bean;

import java.io.Serializable;

/**
 * 
 * @author Ankita Panda
 *
 */
@SuppressWarnings("serial")
public class LandBean implements Serializable{
	
	private int landid;
	private String landLocation;
	private long landValue;
	private String realisedDate;
	/**
	 * @return the landid
	 */
	public int getLandid() {
		return landid;
	}
	/**
	 * @param landid the landid to set
	 */
	public void setLandid(int landid) {
		this.landid = landid;
	}
	/**
	 * @return the landLocation
	 */
	public String getLandLocation() {
		return landLocation;
	}
	/**
	 * @param landLocation the landLocation to set
	 */
	public void setLandLocation(String landLocation) {
		this.landLocation = landLocation;
	}
	/**
	 * @return the landValue
	 */
	public long getLandValue() {
		return landValue;
	}
	/**
	 * @param landValue the landValue to set
	 */
	public void setLandValue(long landValue) {
		this.landValue = landValue;
	}
	/**
	 * @return the realisedDate
	 */
	public String getRealisedDate() {
		return realisedDate;
	}
	/**
	 * @param realisedDate the realisedDate to set
	 */
	public void setRealisedDate(String realisedDate) {
		this.realisedDate = realisedDate;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Land Details Are As Below: \n"
				+ " Landid=" + landid + ", LandLocation=" + landLocation + ", LandValue=" + landValue
				+ ", RealisedDate=" + realisedDate ;
	}
	
	

}
