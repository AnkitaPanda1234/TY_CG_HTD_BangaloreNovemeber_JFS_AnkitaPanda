package com.capgemini.forestrymanagementsystembyusingjdbc.service;

import java.util.List;

import com.capgemini.forestrymanagementsystembyusingjdbc.bean.HauilerBean;
import com.capgemini.forestrymanagementsystembyusingjdbc.dao.HauilerDAO;
import com.capgemini.forestrymanagementsystembyusingjdbc.exception.HauilerException;
import com.capgemini.forestrymanagementsystembyusingjdbc.factory.Factory;

public class HauilerServiceImpl implements HauilerService {

	HauilerDAO dao = Factory.instanceOfHauilerServiceImpl();

	@Override
	public boolean addHauiler(HauilerBean bean) throws HauilerException {
		return dao.addHauiler(bean);
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
	public List<HauilerBean> getHauiler() throws HauilerException {
		return dao.getHauiler();
	}

	@Override
	public HauilerBean searchHauiler(int hauilerId) throws HauilerException {
		return dao.searchHauiler(hauilerId);
	}

}
