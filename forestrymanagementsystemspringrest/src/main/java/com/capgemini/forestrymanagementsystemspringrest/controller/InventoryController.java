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

import com.capgemini.forestrymanagementsystemspringrest.dto.InventoryBean;
import com.capgemini.forestrymanagementsystemspringrest.dto.InventoryResponse;
import com.capgemini.forestrymanagementsystemspringrest.exception.InventoryException;
import com.capgemini.forestrymanagementsystemspringrest.exception.LandException;
import com.capgemini.forestrymanagementsystemspringrest.service.InventoryService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", allowCredentials = "true")
public class InventoryController {
	@Autowired
	private InventoryService service;

	@PostMapping(path = "/addproduct", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public InventoryResponse addproduct(@RequestBody InventoryBean bean) {
		InventoryResponse response = new InventoryResponse();
		if (service.addInventory(bean)) {
			response.setStatusCode(201);
			response.setMessage("Sucess");
			response.setDescription("Product Added Sucessfully");

		} else {
			response.setStatusCode(201);
			response.setMessage("failure");
			response.setDescription("Product already exit");
		}
		return response;
	}

	@DeleteMapping(path = "/deleteproduct/{productid}", produces = MediaType.APPLICATION_JSON_VALUE)
	public InventoryResponse deleteInventory(@PathVariable("productid") int productid) {

		InventoryResponse response = new InventoryResponse();

		boolean deleteFlag = false;
		try {
			deleteFlag = service.deleteInventory(productid);
		} catch (InventoryException e) {
			System.out.println(e.getMessage());
		}

		if (deleteFlag) {
			response.setStatusCode(201);
			response.setMessage("success");
			response.setDescription("Product Details Deleted");
		} else {
			response.setStatusCode(401);
			response.setMessage("failuer");
			response.setDescription("Sorry, Not able to Delete Product ");
		}
		return response;

	}

	@GetMapping(path = "/getAllproduct", produces = MediaType.APPLICATION_JSON_VALUE)
	public InventoryResponse getAllInventory() {
		InventoryResponse response = new InventoryResponse();

		List<InventoryBean> productList = null;

		try {
			productList = service.getAllInventory();
		} catch (NoResultException e) {
			System.out.println(e.getMessage());
		}

		if (productList.isEmpty()) {

			response.setStatusCode(401);
			response.setMessage("failuer");
			response.setDescription("Sorry,Currently There is no Product details found");

		} else {
			response.setStatusCode(201);
			response.setMessage("success");
			response.setDescription("Products Details : ");
			response.setBeans(productList);

		}
		return response;
	}

	// modify
	@PutMapping(path = "/modifyproduct", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public InventoryResponse updateInventory(@RequestBody InventoryBean bean) {
		InventoryResponse response = new InventoryResponse();

		int productid = bean.getProductid();

		List<InventoryBean> inventoyList = new ArrayList<InventoryBean>();
		inventoyList.add(bean);
		boolean updateFlag = false;
		try {
			updateFlag = service.modifyInventory(productid, bean);
		} catch (LandException e) {
			System.out.println(e.getMessage());
		}

		if (updateFlag) {
			response.setStatusCode(201);
			response.setMessage("success");
			response.setDescription("Product details updated successfully");
			response.setBeans(inventoyList);
		} else {
			response.setStatusCode(401);
			response.setMessage("failuer");
			response.setDescription("Sorry,Not Able to update the product Details");
		}
		return response;
	}

	@GetMapping(path = "/searchproduct", produces = MediaType.APPLICATION_JSON_VALUE)
	public InventoryResponse searchproduct(@RequestParam("productid") int productid) {
		InventoryResponse response = new InventoryResponse();

		InventoryBean bean = null;

		try {
			bean = service.getInventory(productid);
		} catch (NoResultException e) {
			System.out.println(e.getMessage());
		}

		if (bean == null) {
			response.setStatusCode(401);
			response.setMessage("failuer");
			response.setDescription("Product With Product Id:" + productid + " Not Present ");

		} else {
			List<InventoryBean> productList = new ArrayList<InventoryBean>();
			productList.add(bean);
			response.setStatusCode(201);
			response.setMessage("success");
			response.setDescription("Product Details : ");
			response.setBeans(productList);

		}
		return response;
	}

}
