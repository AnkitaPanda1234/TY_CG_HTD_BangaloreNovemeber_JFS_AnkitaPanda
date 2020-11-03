package com.capgemini.forestrymanagementsystemspringrest.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.forestrymanagementsystemspringrest.dto.UserBean;
import com.capgemini.forestrymanagementsystemspringrest.dto.UserResponse;
import com.capgemini.forestrymanagementsystemspringrest.exception.CustomerException;
import com.capgemini.forestrymanagementsystemspringrest.exception.LandException;
import com.capgemini.forestrymanagementsystemspringrest.service.LoginService;

@CrossOrigin(origins = "*", allowedHeaders = "*", allowCredentials = "true")
@RestController
public class LoginController {
	@Autowired
	private LoginService service;

	@PostMapping(path = "/login", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public UserResponse Login(@RequestBody UserBean bean) {
		String userName = bean.getUsername();
		String password = bean.getPassword();

		UserBean userBean =null;
		try {
			userBean = service.login(userName, password);
		} catch (CustomerException e) {
			System.out.println(e.getMessage());
		}
		
		
		UserResponse response = new UserResponse();
		if (userBean != null) {
			response.setStatusCode(201);
			response.setMessage("sucess");
			response.setDescription("User found for given credentials");
			response.setBeans(Arrays.asList(userBean));
		} else {
			response.setStatusCode(401);
			response.setMessage("failuer");
			response.setDescription("Invalid credentials,Please Give Correct name and password");

		}
		return response;

	}

	/*
	 * @PostMapping(path = "/clientlogin", produces =
	 * MediaType.APPLICATION_JSON_VALUE, consumes =
	 * MediaType.APPLICATION_JSON_VALUE) public UserResponse
	 * clientLogin(@RequestBody UserBean bean) { UserResponse response = new
	 * UserResponse(); UserBean admin = service.clientlogin(bean.getUsername(),
	 * bean.getPassword()); if (admin != null) { response.setStatusCode(201);
	 * response.setMessage("sucess");
	 * response.setDescription("client found for given credentials");
	 * response.setBeans(Arrays.asList(admin)); } else {
	 * response.setStatusCode(401); response.setMessage("failuer");
	 * response.setDescription("Invalid credentials");
	 * 
	 * } return response;
	 * 
	 * }
	 * 
	 * @PostMapping(path = "/schedulerlogin", produces =
	 * MediaType.APPLICATION_JSON_VALUE, consumes =
	 * MediaType.APPLICATION_JSON_VALUE) public UserResponse
	 * schedulerLogin(@RequestBody UserBean bean) { UserResponse response = new
	 * UserResponse(); UserBean admin = service.schedulerlogin(bean.getUsername(),
	 * bean.getPassword()); if (admin != null) { response.setStatusCode(201);
	 * response.setMessage("sucess");
	 * response.setDescription("scheduler found for given credentials");
	 * response.setBeans(Arrays.asList(admin)); } else {
	 * response.setStatusCode(401); response.setMessage("failuer");
	 * response.setDescription("Invalid credentials");
	 * 
	 * } return response;
	 * 
	 * }
	 */

}
