package com.capgemini.forestrymanagementsystembyusingcollection.service;

import com.capgemini.forestrymanagementsystembyusingcollection.baen.HauilerBean;
import com.capgemini.forestrymanagementsystembyusingcollection.dao.HauilerDAO;
import com.capgemini.forestrymanagementsystembyusingcollection.exception.HauilerException;
import com.capgemini.forestrymanagementsystembyusingcollection.factory.ForestDaoManager;

public class HauilerServiceImpl implements HauilerService{
     HauilerDAO dao=ForestDaoManager.instanceofHauilerDAOImpl();
	@Override
	public boolean addHauiler(HauilerBean bean, int hauilerid) throws HauilerException {
		return dao.addHauiler(bean, hauilerid);
	}

	@Override
	public boolean deleteHauiler(int hauilerid) throws HauilerException {
		return dao.deleteHauiler(hauilerid);
	}

	@Override
	public boolean modifyHauiler(int hauilerid, HauilerBean bean) throws HauilerException {
		return dao.modifyHauiler(hauilerid, bean);
	}

	@Override
	public HauilerBean searchHauiler(int hauilerid) throws HauilerException {
		return dao.searchHauiler(hauilerid);
	}

	@Override
	public void getHauiler() throws HauilerException {
		
		
	}

}
