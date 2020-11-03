package com.capgemini.forestrymanagementsystembyusingjdbc.dao;

import java.sql.Date;
import java.util.List;

import com.capgemini.forestrymanagementsystembyusingjdbc.bean.ContractorBean;
import com.capgemini.forestrymanagementsystembyusingjdbc.exception.ContractException;

public interface ContractorDAO {
	public boolean addContract(ContractorBean bean) throws ContractException;

	public boolean deleteContract(int contractId, int orderId) throws ContractException;

	public List<ContractorBean> getAllContract() throws ContractException;

	public ContractorBean viewContract(int contractId) throws ContractException;

	public ContractorBean viewOrderPerContract(int contractId, int orderId) throws ContractException;

	public List<ContractorBean> getAllContractPerDate(Date schdeuleDate) throws ContractException;;

}
