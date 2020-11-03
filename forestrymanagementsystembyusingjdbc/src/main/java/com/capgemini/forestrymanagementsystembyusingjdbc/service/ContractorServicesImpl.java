package com.capgemini.forestrymanagementsystembyusingjdbc.service;

import java.sql.Date;
import java.util.List;

import com.capgemini.forestrymanagementsystembyusingjdbc.bean.ContractorBean;
import com.capgemini.forestrymanagementsystembyusingjdbc.dao.ContractorDAO;
import com.capgemini.forestrymanagementsystembyusingjdbc.exception.ContractException;
import com.capgemini.forestrymanagementsystembyusingjdbc.factory.Factory;

public class ContractorServicesImpl implements ContractorServices {
	ContractorDAO dao = Factory.instanceOfContractorDAOImpl();

	@Override
	public boolean addContract(ContractorBean bean) throws ContractException {
		return dao.addContract(bean);
	}

	@Override
	public boolean deleteContract(int contractId, int orderId) throws ContractException {
		return dao.deleteContract(contractId, orderId);
	}

	@Override
	public List<ContractorBean> getAllContract() throws ContractException {
		return dao.getAllContract();
	}

	@Override
	public ContractorBean viewContract(int contractId) throws ContractException {
		return dao.viewContract(contractId);
	}

	public ContractorBean viewOrderPerContract(int contractId, int orderId) throws ContractException {
		return dao.viewOrderPerContract(contractId, orderId);
	}

	@Override
	public List<ContractorBean> getAllContractPerDate(Date schdeuleDate) throws ContractException {
		return dao.getAllContractPerDate(schdeuleDate);
	
	}

}
