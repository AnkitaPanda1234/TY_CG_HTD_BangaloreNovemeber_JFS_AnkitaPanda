package com.capgemini.forestrymanagementsystembyusingcollection.baen;

public class LandBean {
	private int landid;
	private String landlocation;
	private long landvalue;
	private String relesedate;

	public int getLandid() {
		return landid;
	}

	public void setLandid(int landid) {
		this.landid = landid;
	}

	public String getLandlocation() {
		return landlocation;
	}

	public void setLandlocation(String landlocation) {
		this.landlocation = landlocation;
	}

	public long getLandvalue() {
		return landvalue;
	}

	public void setLandvalue(long landvalue) {
		this.landvalue = landvalue;
	}

	public String getRelesedate() {
		return relesedate;
	}

	public void setRelesedate(String relesedate) {
		this.relesedate = relesedate;
	}

	@Override
	public String toString() {
		return "LandDetails are as Below :/n" + " landid=" + landid + ", landlocation=" + landlocation + ", landvalue="
				+ landvalue + ", relesedate=" + relesedate + "";
	}

}
