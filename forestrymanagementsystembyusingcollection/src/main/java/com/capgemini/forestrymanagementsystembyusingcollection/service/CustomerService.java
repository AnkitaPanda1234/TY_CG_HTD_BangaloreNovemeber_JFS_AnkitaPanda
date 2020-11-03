package com.capgemini.forestrymanagementsystembyusingcollection.service;

import com.capgemini.forestrymanagementsystembyusingcollection.baen.CustomerBean;
import com.capgemini.forestrymanagementsystembyusingcollection.exception.CustomerException;

public interface CustomerService {
	boolean addCustomer(CustomerBean bean, int customerid) throws CustomerException;

	boolean deleteCustomer(int customerid) throws CustomerException;

	boolean modifyCustomer(int customerid, CustomerBean bean) throws CustomerException;

	
	CustomerBean searchCustomer(int customerid) throws CustomerException;

	public void getCustomer() throws CustomerException;

	


}
