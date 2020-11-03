package com.capgemini.forestrymanagementsystemspringrest.dao;

import java.util.List;

import com.capgemini.forestrymanagementsystemspringrest.dto.CustomerBean;

public interface CustomerDAO {
	public boolean addCustomer(CustomerBean customer);
	
	public boolean deleteCustomer(int customerid);
	
	public List<CustomerBean> getAllCustomer();
	
	public boolean modifyCustomer( int customerid, CustomerBean customer );
	
	public CustomerBean getCustomer(int customerid);

}
