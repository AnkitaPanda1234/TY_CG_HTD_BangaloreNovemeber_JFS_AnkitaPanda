package com.capgemini.forestrymanagementsystembyusingcollection.service;

import com.capgemini.forestrymanagementsystembyusingcollection.baen.LandBean;
import com.capgemini.forestrymanagementsystembyusingcollection.dao.LandDAO;
import com.capgemini.forestrymanagementsystembyusingcollection.exception.LandException;
import com.capgemini.forestrymanagementsystembyusingcollection.factory.ForestDaoManager;

public class LandServiceImpl implements LandService {
	
  LandDAO dao=ForestDaoManager.instanceofLandDAOImpl();
	@Override
	public boolean addDetails(LandBean bean, int landid) throws LandException {
		return dao.addDetails(bean, landid);
	}

	@Override
	public boolean deleteLand(int landid) throws LandException {
		return dao.deleteLand(landid);
	}

	@Override
	public void getAllLandDetails() throws LandException {
		
	}

	@Override
	public boolean updateLand(int landid, LandBean bean) throws LandException {
		return dao.updateLand(landid, bean);
	}

	@Override
	public LandBean getLand(int landid) throws LandException {
		return dao.getLand(landid);
	}

}
