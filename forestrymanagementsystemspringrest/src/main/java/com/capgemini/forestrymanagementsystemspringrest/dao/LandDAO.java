package com.capgemini.forestrymanagementsystemspringrest.dao;

import java.util.List;

import com.capgemini.forestrymanagementsystemspringrest.dto.LandBean;

public interface LandDAO {
	public boolean addLandDetails(LandBean land);

	public boolean deleteLandDetails(int landid);

	public boolean updateLandDeatails(int landid, long landvalue);

	public List<LandBean> showLandDetails();

	public LandBean viewLandDetails(int landid);

}
