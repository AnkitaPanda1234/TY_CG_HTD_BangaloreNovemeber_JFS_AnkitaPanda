package com.capgemini.forestrymanagementsystemspringrest.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.forestrymanagementsystemspringrest.dto.UserResponse;

import com.capgemini.forestrymanagementsystemspringrest.exception.AdminException;


@RestController
public class AdminControllerAdvice {
	
	@ExceptionHandler(AdminException.class)
	public UserResponse handleAdminException(AdminException e)
	{
		UserResponse adminResponse=new UserResponse();
		adminResponse.setStatusCode(501);
		adminResponse.setMessage("Exception");
		adminResponse.setDescription(e.getMessage());
		return adminResponse;
		
	}

	

}
