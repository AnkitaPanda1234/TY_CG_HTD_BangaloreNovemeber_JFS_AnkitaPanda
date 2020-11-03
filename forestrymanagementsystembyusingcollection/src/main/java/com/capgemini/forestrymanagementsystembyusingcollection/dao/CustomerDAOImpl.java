
package com.capgemini.forestrymanagementsystembyusingcollection.dao;

import java.util.HashMap;

import com.capgemini.forestrymanagementsystembyusingcollection.baen.CustomerBean;
import com.capgemini.forestrymanagementsystembyusingcollection.exception.CustomerException;


public class CustomerDAOImpl implements CustomerDAO {

	static HashMap<Integer, CustomerBean> h1 = new HashMap<Integer, CustomerBean>();

	@Override
	public boolean addCustomer(CustomerBean bean, int customerid) throws CustomerException {

		CustomerBean cstBean = searchCustomer(customerid);
		if (cstBean != null) {
			throw new CustomerException("Customer Id: " + customerid + " Already Present,Please Enter another Id");
		} else {
			h1.put(customerid, bean);
		}

		if (h1.containsKey(customerid)) {
			return true;
		} else {
			throw new CustomerException(" Customer ID :" + customerid + " Already Present,Please Enter another Id");
		}

	}

	@Override
	public boolean deleteCustomer(int customerid) throws CustomerException {

		CustomerBean cstBean = searchCustomer(customerid);
		if (cstBean != null) {
			h1.remove(customerid);
			return true;
		} else {
			throw new CustomerException(" Customer ID :" + customerid + " Not Found To Delete");
		}
	}

	@Override
	public boolean modifyCustomer(int customerid, CustomerBean bean) throws CustomerException {

		CustomerBean cstBean = searchCustomer(customerid);
		if (cstBean != null) {
			h1.replace(customerid, bean);
			return true;

		} else {
			throw new CustomerException(" Customer ID :" + customerid + " Not Found To Modify");
		}

	}

	@Override
	public void getCustomer() throws CustomerException {

		if (!h1.isEmpty()) {
			System.out.println(h1);
		} else {
			throw new CustomerException("Customer Details Are Not Present");
		}

	}

	@Override
	public CustomerBean searchCustomer(int customerid) throws CustomerException {
		if (h1.containsKey(customerid)) {
			return h1.get(customerid);
		}
		return null;
	}



}
