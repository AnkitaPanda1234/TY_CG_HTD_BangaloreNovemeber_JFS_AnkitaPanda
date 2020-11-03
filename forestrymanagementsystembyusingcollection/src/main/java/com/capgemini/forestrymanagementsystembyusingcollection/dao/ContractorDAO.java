package com.capgemini.forestrymanagementsystembyusingcollection.dao;

import com.capgemini.forestrymanagementsystembyusingcollection.baen.ContractorBean;
import com.capgemini.forestrymanagementsystembyusingcollection.exception.ContractException;

public interface ContractorDAO {

	public boolean addContarctor(ContractorBean contractor, int contractNo) throws ContractException;

	public boolean deleteContarctor(int contractNo) throws ContractException;

	ContractorBean searchContract(int contractNo) throws ContractException;

	public boolean modifyContract(int contractNo, ContractorBean contractorBean) throws ContractException;

	public void getAllContracts() throws ContractException;

}
