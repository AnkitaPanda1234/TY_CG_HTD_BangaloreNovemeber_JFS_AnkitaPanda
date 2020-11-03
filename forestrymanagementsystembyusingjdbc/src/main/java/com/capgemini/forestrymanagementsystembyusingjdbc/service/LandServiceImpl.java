package com.capgemini.forestrymanagementsystembyusingjdbc.service;

import java.util.List;

import com.capgemini.forestrymanagementsystembyusingjdbc.bean.LandBean;
import com.capgemini.forestrymanagementsystembyusingjdbc.dao.LandDAO;
import com.capgemini.forestrymanagementsystembyusingjdbc.exception.LandException;
import com.capgemini.forestrymanagementsystembyusingjdbc.factory.Factory;

public class LandServiceImpl implements LandService{
	LandDAO dao=Factory.instanceOfLandDaoImpl();

	@Override
	public boolean addLandDetails(LandBean land) throws LandException {
		return dao.addLandDetails(land);
	}

	@Override
	public boolean deleteLandDetails(int landid) throws LandException {
		return dao.deleteLandDetails(landid);
	}

	@Override
	public boolean updateLandDeatails(int landid, long landvalue) throws LandException {
		return dao.updateLandDeatails(landid, landvalue);
	}

	@Override
	public List<LandBean> showLandDetails() throws LandException {
		return dao.showLandDetails();
	}

	@Override
	public LandBean viewLandDetails(int landid) throws LandException {
		return dao.viewLandDetails(landid);
	}

	

}
