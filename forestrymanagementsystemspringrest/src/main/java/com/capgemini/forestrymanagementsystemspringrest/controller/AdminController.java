package com.capgemini.forestrymanagementsystemspringrest.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.capgemini.forestrymanagementsystemspringrest.dto.UserBean;
import com.capgemini.forestrymanagementsystemspringrest.dto.UserResponse;
import com.capgemini.forestrymanagementsystemspringrest.service.AdminService;
@RestController
@CrossOrigin(origins ="*",allowedHeaders="*",allowCredentials="true")
public class AdminController {
	@Autowired
	private AdminService service;
	
	@PostMapping(path="/clientregister",produces=
			MediaType.APPLICATION_JSON_VALUE,consumes=MediaType.APPLICATION_JSON_VALUE)
	
public UserResponse clientregister(@RequestBody UserBean bean)
{
		UserResponse response=new UserResponse();
	if(service.clientregister(bean))
	{
		response.setStatusCode(201);
		response.setMessage("Sucess");
		response.setDescription("Client Added Sucessfully");
		
		
	}
	else
	{
		response.setStatusCode(201);
		response.setMessage("failure");
		response.setDescription("Client already exit");
	}
	
	return response;
}

	@PostMapping(path="/schedulerregister",produces=
			MediaType.APPLICATION_JSON_VALUE,consumes=MediaType.APPLICATION_JSON_VALUE)
	
    public UserResponse register(@RequestBody UserBean bean)
{
		UserResponse response=new UserResponse();
	if(service.clientregister(bean))
	{
		response.setStatusCode(201);
		response.setMessage("Sucess");
		response.setDescription("Scheduler Added Sucessfully");
		
		
	}
	else
	{
		response.setStatusCode(201);
		response.setMessage("failure");
		response.setDescription("Scheduler already exit");
	}
	
	return response;
}
	@DeleteMapping(path="/deleteclient/{id}",produces=
			MediaType.APPLICATION_JSON_VALUE)
	public UserResponse deleteClient(@PathVariable("id")int id)
	{
		UserResponse response=new UserResponse();
		service.removeScheduler(id);
		response.setStatusCode(201);
		response.setMessage("Sucess");
		response.setDescription("Client Details Deleted");
		return response;
		
	}
	@DeleteMapping(path="/deletescheduler/{id}",produces=
			MediaType.APPLICATION_JSON_VALUE)
	public UserResponse deleteScheduler(@PathVariable("id")int id)
	{
		UserResponse response=new UserResponse();
		service.removeScheduler(id);
		response.setStatusCode(201);
		response.setMessage("Sucess");
		response.setDescription("Scheduler Details Deleted");
		return response;
		
	}
	
	@GetMapping(path = "/showclient", produces = MediaType.APPLICATION_JSON_VALUE)
	public UserResponse getAllClient() {
		UserResponse response = new UserResponse();
		List<UserBean> bean = service.showClients();
		if (bean.isEmpty()) {

			response.setStatusCode(401);
			response.setMessage("failuer");
			response.setDescription("Client  does'nt exit");
			
		} else {
			response.setStatusCode(201);
			response.setMessage("success");
			response.setDescription(" All Clients found");
			response.setBeans(bean);
			
		}
		return response;
	}
	
	@GetMapping(path = "/showscheduler", produces = MediaType.APPLICATION_JSON_VALUE)
	public UserResponse getAllScheduler() {
		UserResponse response = new UserResponse();
		List<UserBean> bean = service.showScheduler();
		if (bean.isEmpty()) {

			response.setStatusCode(401);
			response.setMessage("failuer");
			response.setDescription("CliSchedulerent  does'nt exit");
			
		} else {
			response.setStatusCode(201);
			response.setMessage("success");
			response.setDescription(" All Scheduler found");
			response.setBeans(bean);
			
		}
		return response;
	}
	
}
