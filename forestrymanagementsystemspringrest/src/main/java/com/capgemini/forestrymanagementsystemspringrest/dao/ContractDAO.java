package com.capgemini.forestrymanagementsystemspringrest.dao;

import java.util.List;

import com.capgemini.forestrymanagementsystemspringrest.dto.ContractBean;

public interface ContractDAO {
	public boolean addContract(ContractBean bean);

	public boolean deleteContract(int contractId);

	public List<ContractBean> getContract();

	public ContractBean viewContract(int contractId);

}
