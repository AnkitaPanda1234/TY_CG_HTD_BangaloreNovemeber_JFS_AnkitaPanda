package com.capgemini.forestrymanagementsystembyusingjdbc.service;

import java.util.List;

import com.capgemini.forestrymanagementsystembyusingjdbc.bean.CustomerBean;
import com.capgemini.forestrymanagementsystembyusingjdbc.dao.CustomerDAO;
import com.capgemini.forestrymanagementsystembyusingjdbc.exception.CustomerException;
import com.capgemini.forestrymanagementsystembyusingjdbc.factory.Factory;

public class CustomerServicesImpl implements CustomerServices {
	CustomerDAO dao = Factory.instanceOfCustomerDAOImpl();

	@Override
	public boolean addCustomer(CustomerBean customer) throws CustomerException {
		return dao.addCustomer(customer);
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
	public List<CustomerBean> getAllCustomers() throws CustomerException {
		return dao.getAllCustomers();

	}

	@Override
	public CustomerBean viewCustomer(int customerid) throws CustomerException {
		return dao.viewCustomer(customerid);
	}

}
