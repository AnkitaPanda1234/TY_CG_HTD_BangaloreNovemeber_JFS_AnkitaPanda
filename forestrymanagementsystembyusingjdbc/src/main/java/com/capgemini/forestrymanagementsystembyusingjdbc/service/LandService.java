package com.capgemini.forestrymanagementsystembyusingjdbc.service;

import java.util.List;

import com.capgemini.forestrymanagementsystembyusingjdbc.bean.LandBean;
import com.capgemini.forestrymanagementsystembyusingjdbc.exception.LandException;

public interface LandService {
	public boolean addLandDetails(LandBean land) throws LandException;

	public boolean deleteLandDetails(int landid) throws LandException;

	public boolean updateLandDeatails(int landid, long landvalue) throws LandException;

	public List<LandBean> showLandDetails() throws LandException;

	public LandBean viewLandDetails(int landid) throws LandException;

}
