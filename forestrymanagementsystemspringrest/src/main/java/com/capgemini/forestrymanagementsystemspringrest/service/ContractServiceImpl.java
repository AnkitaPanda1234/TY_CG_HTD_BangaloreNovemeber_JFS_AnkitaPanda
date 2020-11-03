package com.capgemini.forestrymanagementsystemspringrest.service;

import java.util.List;

import javax.persistence.NoResultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.forestrymanagementsystemspringrest.dao.ContractDAO;
import com.capgemini.forestrymanagementsystemspringrest.dao.CustomerDAO;
import com.capgemini.forestrymanagementsystemspringrest.dao.InventoryDAO;
import com.capgemini.forestrymanagementsystemspringrest.dto.ContractBean;
import com.capgemini.forestrymanagementsystemspringrest.dto.CustomerBean;
import com.capgemini.forestrymanagementsystemspringrest.dto.InventoryBean;
import com.capgemini.forestrymanagementsystemspringrest.exception.CustomerException;
import com.capgemini.forestrymanagementsystemspringrest.util.Validation;

@Service
public class ContractServiceImpl implements ContractService {
	@Autowired
	private ContractDAO dao;

	@Autowired
	private CustomerDAO customerDao;
	@Autowired
	private InventoryDAO inventoryDao;

	@SuppressWarnings("static-access")
	@Override
	public boolean addContract(ContractBean contractBean) {

		boolean addFlag = false;
		int customerId = contractBean.getCustomerId();
		int productId = contractBean.getProductId();
		long orderQunatity = contractBean.getQunatity();
		InventoryBean inventoryBean = null;
		long availableQuantity;
		long finalQunatity = 0;

		CustomerBean cstBean = null;
		try {
			cstBean = customerDao.getCustomer(customerId);
		} catch (NoResultException e) {
			System.out.println(e.getMessage());
		}

		if (cstBean == null) {
			throw new CustomerException("customer not found for customer id:" + customerId);
		}

		try {
			inventoryBean = inventoryDao.getInventory(productId);
		} catch (NoResultException e) {
			System.out.println(e.getMessage());
		}

		if (inventoryBean == null) {
			throw new CustomerException("product not found for productId id:" + productId);
		} else {
			availableQuantity = inventoryBean.getProductquantity();
		}

		System.out.println("availableQuantity in contract ==>" + availableQuantity);

		if (availableQuantity < orderQunatity) {
			throw new CustomerException("Currently don't have the total product in our stock ");
		} else if (availableQuantity > orderQunatity) {
			finalQunatity = availableQuantity - orderQunatity;
		}

		System.out.println("finalQunatity in contract ==>" + finalQunatity);

//		Validation v = new Validation();
//		String date = contractBean.getDeliveryDate();
//		if (v.isValidDate(date)) {
//			contractBean.setDeliveryDate(date);
//		} else {
//			throw new CustomerException("Please Enter The Date in the Correct Date Format :dd-MM-yyyy ");
//		}
		addFlag = dao.addContract(contractBean);

		if (addFlag) {
		//	inventoryBean.setProductquantity(finalQunatity);
		//	inventoryDao.modifyInventory(productId, inventoryBean);
			return true;
		} else {
			return false;
		}

	}

	@Override
	public boolean deleteContract(int contractId) {
		boolean deleteFlag = false;
		InventoryBean inventoryBean = null;
		long availableQuantity = 0;
		ContractBean contractBean = null;

		try {
			contractBean = dao.viewContract(contractId);
		} catch (NoResultException e) {
			System.out.println(e.getMessage());
		}

		if (contractBean == null) {
			throw new CustomerException("Contract not found for  id:" + contractId);
		} else {
			deleteFlag = dao.deleteContract(contractId);
		}
		return deleteFlag;

	}

	@Override
	public List<ContractBean> getContract() {
		return dao.getContract();
	}

	@Override
	public ContractBean viewContract(int contractId) {
		return dao.viewContract(contractId);
	}

}
