package com.capgemini.forestrymanagementsystemspringrest.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.capgemini.forestrymanagementsystemspringrest.dto.LandResponse;
import com.capgemini.forestrymanagementsystemspringrest.exception.LandException;

public class LandControllerAdvice {
	@RestControllerAdvice
	public class LandControlleAdvice {
		@ExceptionHandler(LandException.class)
		public LandResponse handleLandException(LandException e)
		{
			LandResponse landresponse=new LandResponse();
			landresponse.setStatusCode(501);
			landresponse.setMessage("Exception");
			landresponse.setDescription(e.getMessage());
			return landresponse;
			
		}

}
}