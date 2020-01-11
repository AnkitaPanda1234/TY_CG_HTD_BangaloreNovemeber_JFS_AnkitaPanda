package com.capgemini.retailermaintenancesystemapplicationdevelopment.config.controller.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.retailermaintenancesystemapplicationdevelopment.config.controller.dto.OrderBean;
import com.capgemini.retailermaintenancesystemapplicationdevelopment.config.controller.dto.OrderResponse;
import com.capgemini.retailermaintenancesystemapplicationdevelopment.config.controller.dto.ProductBean;
import com.capgemini.retailermaintenancesystemapplicationdevelopment.config.controller.dto.ProductResponse;
import com.capgemini.retailermaintenancesystemapplicationdevelopment.config.controller.service.OrderService;

@RestController
public class OrderController {
	@Autowired
	private OrderService service;
	@PostMapping(path = "/addorder", 
			produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
			public OrderResponse addProduct(@RequestBody OrderBean order) {
		OrderResponse response = new OrderResponse();
				if (service.addOrder(order)) {
					response.setStatusCode(201);
					response.setMessage("Sucess");
					response.setDescription("Product Registered");

				} else {
					response.setStatusCode(401);
					response.setMessage("Failure");
					response.setDescription(" Product Already Exits");
				}
				return response;
			}
	
	

}
