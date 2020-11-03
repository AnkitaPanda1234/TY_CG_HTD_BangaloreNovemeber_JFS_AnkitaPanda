package com.capgemini.forestrymanagementsystemspringrest.controller;
import org.springframework.web.bind.annotation.ExceptionHandler;

import org.springframework.web.bind.annotation.RestController;

import com.capgemini.forestrymanagementsystemspringrest.dto.ScheduleResponse;

import com.capgemini.forestrymanagementsystemspringrest.exception.SchedulerException;

@RestController
public class ScheduleControllerAdvice {
	@ExceptionHandler(SchedulerException.class)
	public ScheduleResponse handleEmployeeException(SchedulerException e)
	{
		ScheduleResponse schedulerResponse=new ScheduleResponse();
		schedulerResponse.setStatusCode(501);
		schedulerResponse.setMessage("Exception");
		schedulerResponse.setDescription(e.getMessage());
		return schedulerResponse;
		
	}
	

}
