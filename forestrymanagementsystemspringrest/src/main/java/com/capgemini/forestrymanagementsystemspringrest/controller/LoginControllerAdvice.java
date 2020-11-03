package com.capgemini.forestrymanagementsystemspringrest.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;

import org.springframework.web.bind.annotation.RestController;

import com.capgemini.forestrymanagementsystemspringrest.dto.UserResponse;
import com.capgemini.forestrymanagementsystemspringrest.exception.LoginException;

@RestController
public class LoginControllerAdvice {
	
	@ExceptionHandler(LoginException.class)
	public UserResponse handleAdminException(LoginException e)
	{
		UserResponse adminResponse=new UserResponse();
		adminResponse.setStatusCode(501);
		adminResponse.setMessage("Exception");
		adminResponse.setDescription(e.getMessage());
		return adminResponse;
		
	}

}
