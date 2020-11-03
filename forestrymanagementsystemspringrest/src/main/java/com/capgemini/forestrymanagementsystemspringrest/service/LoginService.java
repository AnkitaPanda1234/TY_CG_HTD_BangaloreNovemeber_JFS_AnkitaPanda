package com.capgemini.forestrymanagementsystemspringrest.service;

import com.capgemini.forestrymanagementsystemspringrest.dto.UserBean;

public interface LoginService {

	public UserBean login(String username, String password);

	// public UserBean clientlogin(String username, String password);
	//
	// public UserBean schedulerlogin(String username, String password);

}
