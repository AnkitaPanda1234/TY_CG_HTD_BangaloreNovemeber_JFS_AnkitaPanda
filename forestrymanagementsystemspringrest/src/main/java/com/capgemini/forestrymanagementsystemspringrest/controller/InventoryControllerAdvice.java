package com.capgemini.forestrymanagementsystemspringrest.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.forestrymanagementsystemspringrest.dto.InventoryResponse;
import com.capgemini.forestrymanagementsystemspringrest.exception.InventoryException;

@RestController
public class InventoryControllerAdvice {
	@ExceptionHandler(InventoryException.class)
	public InventoryResponse handleInventoryException(InventoryException e)
	{
		InventoryResponse inventoryresponse=new InventoryResponse();
		inventoryresponse.setStatusCode(501);
		inventoryresponse.setMessage("Exception");
		inventoryresponse.setDescription(e.getMessage());
		return inventoryresponse;
		
	}

}
