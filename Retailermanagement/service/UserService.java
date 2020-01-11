package com.capgemini.retailermaintenancesystemapplicationdevelopment.config.controller.service;

import com.capgemini.retailermaintenancesystemapplicationdevelopment.config.controller.dto.UserBean;

public interface UserService {
	
   public boolean add(UserBean bean);
	
	public UserBean auth(String email,String password);
	
	public boolean changePassword(int id,String password);
	

}
