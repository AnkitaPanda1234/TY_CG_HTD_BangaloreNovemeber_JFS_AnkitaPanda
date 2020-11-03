package com.capgemini.forestrymanagementsystembyusingcollection.service;

import com.capgemini.forestrymanagementsystembyusingcollection.dao.AdminDAO;
import com.capgemini.forestrymanagementsystembyusingcollection.exception.LoginException;
import com.capgemini.forestrymanagementsystembyusingcollection.factory.ForestDaoManager;

public class AdminServiceImpl implements AdminService {
      AdminDAO dao=ForestDaoManager.instanceofAdminDAOImpl();
	
	@Override
	public boolean adminLogin(String username, String Password) throws LoginException {
		return dao.adminLogin(username, Password);
	}

	

}
