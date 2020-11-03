package com.capgemini.forestrymanagementsystembyusingcollection.service;

import com.capgemini.forestrymanagementsystembyusingcollection.baen.ContractorBean;
import com.capgemini.forestrymanagementsystembyusingcollection.dao.ContractorDAO;
import com.capgemini.forestrymanagementsystembyusingcollection.exception.ContractException;
import com.capgemini.forestrymanagementsystembyusingcollection.factory.ForestDaoManager;

public class ContractServiceImpl implements ContractService {
	ContractorDAO dao=ForestDaoManager.instanceofContractorDAOImpl();

	@Override
	public boolean addContarctor(ContractorBean contractor, int contractNo) throws ContractException {
		return dao.addContarctor(contractor, contractNo);
	}

	@Override
	public boolean deleteContarctor(int contractNo) throws ContractException {
		return dao.deleteContarctor(contractNo);
	}

	@Override
	public ContractorBean searchContract(int contractNo) throws ContractException {
		
		return dao.searchContract(contractNo);
	}

	@Override
	public boolean modifyContract(int contractNo, ContractorBean contractorBean) throws ContractException {
		return dao.modifyContract(contractNo, contractorBean);
	}

	@Override
	public void getAllContracts() throws ContractException {
	
		
	}

}
