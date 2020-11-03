package com.capgemini.forestrymanagementsystemspringrest.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import com.capgemini.forestrymanagementsystemspringrest.dto.ContractResponse;
import com.capgemini.forestrymanagementsystemspringrest.exception.ContractorException;

@RestController
public class ContractControllerAdvice {
	@ExceptionHandler(ContractorException.class)
	public ContractResponse handleContractorException(ContractorException e)
	{
		ContractResponse contractResponse=new ContractResponse();
		contractResponse.setStatusCode(501);
		contractResponse.setMessage("Exception");
		contractResponse.setDescription(e.getMessage());
		return contractResponse;
		
	}

}
