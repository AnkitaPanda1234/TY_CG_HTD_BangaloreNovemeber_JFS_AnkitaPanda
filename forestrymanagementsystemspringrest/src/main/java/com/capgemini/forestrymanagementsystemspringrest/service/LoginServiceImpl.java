package com.capgemini.forestrymanagementsystemspringrest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.forestrymanagementsystemspringrest.dao.LoginDAO;
import com.capgemini.forestrymanagementsystemspringrest.dto.UserBean;

@Service
public class LoginServiceImpl implements LoginService {
	@Autowired
	private LoginDAO logindao;

	@Override
	public UserBean login(String username, String password) {
		
		return logindao.login(username, password);
	}


	/*
	 * @Override public UserBean clientlogin(String username, String password) {
	 * 
	 * return logindao.clientlogin(username, password); }
	 * 
	 * @Override public UserBean schedulerlogin(String username, String password) {
	 * 
	 * return logindao.schedulerlogin(username, password); }
	 */

}
