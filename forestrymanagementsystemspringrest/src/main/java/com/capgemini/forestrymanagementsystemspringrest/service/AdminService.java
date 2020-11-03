package com.capgemini.forestrymanagementsystemspringrest.service;

import java.util.List;

import com.capgemini.forestrymanagementsystemspringrest.dto.UserBean;

public interface AdminService {
	public boolean clientregister(UserBean clientBean);
	public boolean schedulerregister(UserBean schedulerBean);
	public boolean removeClient(int id);
	public List<UserBean> showClients();
	public boolean removeScheduler(int id);
	public List<UserBean> showScheduler();
		
		
		
		


}
