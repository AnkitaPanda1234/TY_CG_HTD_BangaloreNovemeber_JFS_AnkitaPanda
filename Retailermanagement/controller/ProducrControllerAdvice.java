package com.capgemini.retailermaintenancesystemapplicationdevelopment.config.controller.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.retailermaintenancesystemapplicationdevelopment.config.controller.dto.OrderResponse;
import com.capgemini.retailermaintenancesystemapplicationdevelopment.config.controller.dto.ProductResponse;
import com.capgemini.retailermaintenancesystemapplicationdevelopment.config.controller.exception.OrderException;
import com.capgemini.retailermaintenancesystemapplicationdevelopment.config.controller.exception.ProductException;
@RestController
public class ProducrControllerAdvice {
	@ExceptionHandler(ProductException.class)
	public ProductResponse handleProductException(ProductException e)
	{
		ProductResponse productResponse=new ProductResponse();
		productResponse.setStatusCode(501);
		productResponse.setMessage("Exception");
		productResponse.setDescription(e.getMessage());
		return productResponse;
		
	}


}
