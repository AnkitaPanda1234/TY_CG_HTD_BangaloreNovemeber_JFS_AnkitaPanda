package com.capgemini.forestrymanagementsystembyusingcollection.service;

import com.capgemini.forestrymanagementsystembyusingcollection.exception.LoginException;

public interface AdminService {
	
	public boolean adminLogin(String username, String Password) throws LoginException;

}
