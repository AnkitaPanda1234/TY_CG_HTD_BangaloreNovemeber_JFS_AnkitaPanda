package com.capgemini.forestrymanagementsystembyusingjdbc.dao;

import java.util.List;

import com.capgemini.forestrymanagementsystembyusingjdbc.bean.CustomerBean;
import com.capgemini.forestrymanagementsystembyusingjdbc.exception.CustomerException;

public interface CustomerDAO {
	public boolean addCustomer(CustomerBean customer)throws CustomerException;

	public boolean deleteCustomer(int customerid) throws CustomerException;

	public boolean modifyCustomer(int customerid, CustomerBean Bean) throws CustomerException;

	List<CustomerBean> getAllCustomers() throws CustomerException;
	
	public CustomerBean viewCustomer(int customerid)throws CustomerException;

}
