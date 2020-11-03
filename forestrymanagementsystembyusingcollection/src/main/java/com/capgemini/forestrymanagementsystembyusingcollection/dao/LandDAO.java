package com.capgemini.forestrymanagementsystembyusingcollection.dao;

import com.capgemini.forestrymanagementsystembyusingcollection.baen.LandBean;
import com.capgemini.forestrymanagementsystembyusingcollection.exception.LandException;

public interface LandDAO {
	public boolean addDetails(LandBean bean, int landid) throws LandException;

	public boolean deleteLand(int landid) throws LandException;

	public void getAllLandDetails() throws LandException;

	public boolean updateLand(int landid, LandBean bean) throws LandException;

	public LandBean getLand(int landid) throws LandException;

}
