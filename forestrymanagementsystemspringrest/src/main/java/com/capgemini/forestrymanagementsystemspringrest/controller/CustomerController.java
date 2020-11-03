
package com.capgemini.forestrymanagementsystemspringrest.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.NoResultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.forestrymanagementsystemspringrest.dto.CustomerBean;
import com.capgemini.forestrymanagementsystemspringrest.dto.CustomerResponse;
import com.capgemini.forestrymanagementsystemspringrest.exception.CustomerException;
import com.capgemini.forestrymanagementsystemspringrest.exception.LandException;
import com.capgemini.forestrymanagementsystemspringrest.service.CustomerService;

@CrossOrigin(origins = "*", allowedHeaders = "*", allowCredentials = "true")
@RestController
public class CustomerController {
	@Autowired
	private CustomerService service;

	@PostMapping(path = "/addcustomer", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public CustomerResponse register(@RequestBody CustomerBean bean) {
		CustomerResponse response = new CustomerResponse();
		if (service.addCustomer(bean)) {
			response.setStatusCode(201);
			response.setMessage("Sucess");
			response.setDescription("Customer Added Sucessfully");

		} else {
			response.setStatusCode(201);
			response.setMessage("failure");
			response.setDescription("Customer Already Present");
		}

		return response;
	}

	@DeleteMapping(path = "/deletecustomer/{customerid}", produces = MediaType.APPLICATION_JSON_VALUE)
	public CustomerResponse deleteCustomer(@PathVariable("customerid") int customerid) {

		CustomerResponse response = new CustomerResponse();

		boolean deleteFlag = false;
		try {
			deleteFlag = service.deleteCustomer(customerid);
		} catch (CustomerException e) {
			System.out.println(e.getMessage());
		}

		if (deleteFlag) {
			response.setStatusCode(201);
			response.setMessage("success");
			response.setDescription("Customer Details Deleted");
		} else {
			response.setStatusCode(401);
			response.setMessage("failuer");
			response.setDescription("Sorry, Not able to Delete Product ");
		}
		return response;

	}

	@GetMapping(path = "/getAllcustomer", produces = MediaType.APPLICATION_JSON_VALUE)
	public CustomerResponse getAllCustomer() {
		CustomerResponse response = new CustomerResponse();

		List<CustomerBean> customerList = null;

		try {
			customerList = service.getAllCustomer();
		} catch (NoResultException e) {
			System.out.println(e.getMessage());
		}

		if (customerList.isEmpty()) {

			response.setStatusCode(401);
			response.setMessage("failuer");
			response.setDescription("Sorry,Currently There is no Customer details found");

		} else {
			response.setStatusCode(201);
			response.setMessage("success");
			response.setDescription("Customers Details :");
			response.setBeans(customerList);

		}
		return response;
	}

	@PutMapping(path = "/modifycustomer", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public CustomerResponse updateCustomer(@RequestBody CustomerBean bean) {
		CustomerResponse response = new CustomerResponse();

		int customerId = bean.getCustomerid();

		List<CustomerBean> customerList = new ArrayList<CustomerBean>();
		customerList.add(bean);
		boolean updateFlag = false;
		try {
			updateFlag = service.modifyCustomer(customerId, bean);
		} catch (LandException e) {
			System.out.println(e.getMessage());
		}

		if (updateFlag) {
			response.setStatusCode(201);
			response.setMessage("success");
			response.setDescription("Customer details updated successfully");
			response.setBeans(customerList);
		} else {
			response.setStatusCode(401);
			response.setMessage("failuer");
			response.setDescription("Sorry,Not Able to update the Customer Details");
		}
		return response;
	}

	@GetMapping(path = "/searchCustomer", produces = MediaType.APPLICATION_JSON_VALUE)
	public CustomerResponse getCustomer(@RequestParam("customerid") int customerid) throws CustomerException {
		CustomerResponse response = new CustomerResponse();

		CustomerBean bean = null;

		try {
			bean = service.getCustomer(customerid);
		} catch (NoResultException e) {
			System.out.println(e.getMessage());
		}

		if (bean == null) {
			response.setStatusCode(401);
			response.setMessage("failuer");
			response.setDescription("Customer With  Id:" + customerid + " Not Present ");

		} else {
			List<CustomerBean> customerList = new ArrayList<CustomerBean>();
			customerList.add(bean);
			response.setStatusCode(201);
			response.setMessage("success");
			response.setDescription("Product Details : ");
			response.setBeans(customerList);

		}
		return response;
	}
}
