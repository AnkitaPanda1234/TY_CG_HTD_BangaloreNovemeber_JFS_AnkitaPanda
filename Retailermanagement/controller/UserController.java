package com.capgemini.retailermaintenancesystemapplicationdevelopment.config.controller.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.retailermaintenancesystemapplicationdevelopment.config.controller.dto.UserBean;
import com.capgemini.retailermaintenancesystemapplicationdevelopment.config.controller.dto.UserResponse;
import com.capgemini.retailermaintenancesystemapplicationdevelopment.config.controller.service.UserService;

@RestController
  public class UserController {
	@Autowired
	private UserService service;
	@PostMapping(path="/userregister",produces=
			MediaType.APPLICATION_JSON_VALUE,consumes=MediaType.APPLICATION_JSON_VALUE)
	public UserResponse register(@RequestBody UserBean bean)
	{
		UserResponse response=new UserResponse();
		if(service.add(bean))
		{
			response.setStatusCode(201);
			response.setMessage("sucess");
			response.setDescription("Employee Registered");
			
		}
		else
		{
			response.setStatusCode(401);
			response.setMessage("failure");
			response.setDescription("Email already exit");
		}
		
		return response;
	}
	@PostMapping(path="/auth",produces=
			MediaType.APPLICATION_JSON_VALUE,consumes=MediaType.APPLICATION_JSON_VALUE)
	public UserResponse auth(@RequestBody UserBean bean)
	{
		UserBean userBean= service.auth(bean.getEmail(),bean.getPassword());
		UserResponse response=new UserResponse();
		if(userBean!=null)
		{
			response.setStatusCode(201);
			response.setMessage("Sucess");
			response.setDescription("Log In Sucessfull");
			response.setBeans(Arrays.asList(userBean));
		}
		else
		{
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("Invalid Password");
		}
		return response;
		
		
	}
	@PutMapping(path="/change-password",produces=
			MediaType.APPLICATION_JSON_VALUE,consumes=MediaType.APPLICATION_JSON_VALUE)
	public UserResponse changePassword(@RequestBody UserBean bean)
	{
		UserResponse response=new UserResponse();
		if(service.changePassword(bean.getId(), bean.getPassword()))
		{
			response.setStatusCode(201);
			response.setMessage("Sucess");
			response.setDescription("user Password Changed");
		}
		else
		{
			response.setStatusCode(201);
			response.setMessage("Sucess");
			response.setDescription("Password is not matched");
		}
			
		return response;
	}

}
