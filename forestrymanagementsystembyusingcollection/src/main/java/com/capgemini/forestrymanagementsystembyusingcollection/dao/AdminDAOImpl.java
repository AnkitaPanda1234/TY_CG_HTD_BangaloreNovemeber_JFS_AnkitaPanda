package com.capgemini.forestrymanagementsystembyusingcollection.dao;

import java.util.HashMap;

import com.capgemini.forestrymanagementsystembyusingcollection.baen.AdminBean;
import com.capgemini.forestrymanagementsystembyusingcollection.exception.LoginException;

public class AdminDAOImpl implements AdminDAO {
	static HashMap<String, AdminBean> h1 = new HashMap<String, AdminBean>();

	@Override
	public boolean adminLogin(String username, String password) throws LoginException {
		if (password.equalsIgnoreCase("Admin@1234")
				&& username.equalsIgnoreCase("Admin")) {
			return true;
		} else {
			throw new LoginException("Please Provide The Correct Credentials For Admin Login");
		}

	}

}
