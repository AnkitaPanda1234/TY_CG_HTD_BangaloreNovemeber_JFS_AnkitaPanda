package com.capgemini.forestrymanagementsystembyusingcollection.service;

import com.capgemini.forestrymanagementsystembyusingcollection.baen.CustomerBean;
import com.capgemini.forestrymanagementsystembyusingcollection.dao.CustomerDAO;
import com.capgemini.forestrymanagementsystembyusingcollection.exception.CustomerException;
import com.capgemini.forestrymanagementsystembyusingcollection.factory.ForestDaoManager;

public class CustomerServiceImpl implements CustomerService{
   CustomerDAO dao=ForestDaoManager.instanceofCustomerDAOImpl();
	@Override
	public boolean addCustomer(CustomerBean bean, int customerid) throws CustomerException {
		return dao.addCustomer(bean, customerid);
	}

	@Override
	public boolean deleteCustomer(int customerid) throws CustomerException {
		return dao.deleteCustomer(customerid);
	}

	@Override
	public boolean modifyCustomer(int customerid, CustomerBean bean) throws CustomerException {
		return dao.modifyCustomer(customerid, bean);
	}

	@Override
	public CustomerBean searchCustomer(int customerid) throws CustomerException {
		return dao.searchCustomer(customerid);
	}

	@Override
	public void getCustomer() throws CustomerException {
		
		
	}

}
