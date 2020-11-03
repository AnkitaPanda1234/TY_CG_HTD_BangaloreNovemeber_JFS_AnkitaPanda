package com.capgemini.forestrymanagementsystemspringrest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.forestrymanagementsystemspringrest.dao.CustomerDAO;
import com.capgemini.forestrymanagementsystemspringrest.dto.CustomerBean;
import com.capgemini.forestrymanagementsystemspringrest.exception.CustomerException;
import com.capgemini.forestrymanagementsystemspringrest.util.Validation;

@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private CustomerDAO dao;

	@Override
	public boolean addCustomer(CustomerBean customer) {
		Validation v = new Validation();
		String customername = customer.getCustomerName();
		if (v.nameValidation(customername)) {
			customer.setCustomerName(customername);
		} else {
			throw new CustomerException("Enter Only alphabate in Customer Name");
		}

		String customertown = customer.getTown();
		if (v.townValidation(customertown)) {
			customer.setTown(customertown);
		} else {
			throw new CustomerException("Town should contain only letters");
		}
		String address = customer.getStreetAddress1();
		if (v.addresValidation(address)) {
			customer.setStreetAddress1(address);
		} else {
			throw new CustomerException("Enter The Valid Address");
		}
		int postalcode = customer.getPostalCode();
		if (v.postalCodeValidation(postalcode)) {
			customer.getPostalCode();
		} else {
			throw new CustomerException("Postal code must contain 6 digit numbers");
		}
		String email = customer.getEmail();
		if (v.emailValidation(email)) {
			customer.getEmail();
		} else {
			throw new CustomerException("Enter the proper formate of email in Email ");
		}
		long number = customer.getTelephoneNum();
		String telephoneNum = String.valueOf(number);
		if (v.mobileNoValidation(telephoneNum)) {
			customer.setTelephoneNum(number);
		} else {
			throw new CustomerException("Please enter 10 digit number(Must Start with either 7 or 8 or 9).");
		}
		return dao.addCustomer(customer);
	}

	@Override
	public boolean deleteCustomer(int customerid) {
		return dao.deleteCustomer(customerid);
	}

	@Override
	public List<CustomerBean> getAllCustomer() {
		return dao.getAllCustomer();
	}

	@Override
	public boolean modifyCustomer(int customerid, CustomerBean customer) {
		Validation v = new Validation();
		String customername = customer.getCustomerName();
		if (v.nameValidation(customername)) {
			customer.setCustomerName(customername);
		} else {
			throw new CustomerException("Enter Only alphabate in Customer Name");
		}

		String customertown = customer.getTown();
		if (v.townValidation(customertown)) {
			customer.setTown(customertown);
		} else {
			throw new CustomerException("Town should contain only letters");
		}
		String address = customer.getStreetAddress1();
		if (v.addresValidation(address)) {
			customer.setStreetAddress1(address);
		} else {
			throw new CustomerException("Enter The Valid Address");
		}
		int postalcode = customer.getPostalCode();
		if (v.postalCodeValidation(postalcode)) {
			customer.getPostalCode();
		} else {
			throw new CustomerException("Postal code must contain 6 digit numbers");
		}
		String email = customer.getEmail();
		if (v.emailValidation(email)) {
			customer.getEmail();
		} else {
			throw new CustomerException("Enter the proper formate of email in Email ");
		}

		long number = customer.getTelephoneNum();
		String telephoneNum = String.valueOf(number);
		if (v.mobileNoValidation(telephoneNum)) {
			customer.setTelephoneNum(number);
		} else {
			throw new CustomerException("Please enter 10 digit number(Must Start with either 7 or 8 or 9).");
		}

		return dao.modifyCustomer(customerid, customer);
	}

	@Override
	public CustomerBean getCustomer(int customerid) {
		return dao.getCustomer(customerid);
	}

}
