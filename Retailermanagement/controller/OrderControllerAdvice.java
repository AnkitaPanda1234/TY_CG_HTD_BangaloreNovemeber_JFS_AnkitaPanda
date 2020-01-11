package com.capgemini.retailermaintenancesystemapplicationdevelopment.config.controller.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.retailermaintenancesystemapplicationdevelopment.config.controller.dto.OrderResponse;
import com.capgemini.retailermaintenancesystemapplicationdevelopment.config.controller.dto.UserResponse;
import com.capgemini.retailermaintenancesystemapplicationdevelopment.config.controller.exception.OrderException;
import com.capgemini.retailermaintenancesystemapplicationdevelopment.config.controller.exception.UserException;
@RestController
public class OrderControllerAdvice {
		@ExceptionHandler(OrderException.class)
		public OrderResponse handleOrderException(OrderException e)
		{
			OrderResponse orderResponse=new OrderResponse();
			orderResponse.setStatusCode(501);
			orderResponse.setMessage("Exception");
			orderResponse.setDescription(e.getMessage());
			return orderResponse;
			
		}

}
