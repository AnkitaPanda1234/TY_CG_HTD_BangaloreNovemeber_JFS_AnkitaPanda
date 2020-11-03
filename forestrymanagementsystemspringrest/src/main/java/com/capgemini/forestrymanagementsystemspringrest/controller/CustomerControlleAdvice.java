package com.capgemini.forestrymanagementsystemspringrest.controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.capgemini.forestrymanagementsystemspringrest.dto.CustomerResponse;
import com.capgemini.forestrymanagementsystemspringrest.exception.CustomerException;

@RestControllerAdvice
public class CustomerControlleAdvice {
	@ExceptionHandler(CustomerException.class)
	public CustomerResponse handleEmployeeException(CustomerException e)
	{
		CustomerResponse customerresponse=new CustomerResponse();
		customerresponse.setStatusCode(501);
		customerresponse.setMessage("Exception");
		customerresponse.setDescription(e.getMessage());
		return customerresponse;
		
	}
	

}
