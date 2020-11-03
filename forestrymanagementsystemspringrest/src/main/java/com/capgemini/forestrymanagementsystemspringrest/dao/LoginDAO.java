package com.capgemini.forestrymanagementsystemspringrest.dao;

import com.capgemini.forestrymanagementsystemspringrest.dto.UserBean;

public interface LoginDAO {

	public UserBean login(String username,String password);

//	public UserBean clientlogin(String username, String password);
//
//	public UserBean schedulerlogin(String username, String password);

}
