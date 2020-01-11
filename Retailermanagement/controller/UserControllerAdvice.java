package com.capgemini.retailermaintenancesystemapplicationdevelopment.config.controller.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.retailermaintenancesystemapplicationdevelopment.config.controller.dto.UserResponse;
import com.capgemini.retailermaintenancesystemapplicationdevelopment.config.controller.exception.UserException;

@RestController
public class UserControllerAdvice {
	@ExceptionHandler(UserException.class)
	public UserResponse handleAdminException(UserException e)
	{
		UserResponse userresponse=new UserResponse();
		userresponse.setStatusCode(501);
		userresponse.setMessage("Exception");
		userresponse.setDescription(e.getMessage());
		return userresponse;
		
	}

}
