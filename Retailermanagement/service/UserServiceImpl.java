package com.capgemini.retailermaintenancesystemapplicationdevelopment.config.controller.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.retailermaintenancesystemapplicationdevelopment.config.controller.dao.UserDao;
import com.capgemini.retailermaintenancesystemapplicationdevelopment.config.controller.dto.UserBean;
@Service
public class UserServiceImpl implements UserService {
@Autowired
private UserDao dao;
	@Override
	public boolean add(UserBean bean) {
		// TODO Auto-generated method stub
		return dao.add(bean);
	}

	@Override
	public UserBean auth(String email, String password) {
		return dao.auth(email, password);
	}

	@Override
	public boolean changePassword(int id, String password) {
		// TODO Auto-generated method stub
		return dao.changePassword(id, password);
	}

}
