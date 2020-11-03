package com.capgemini.forestrymanagementsystembyusingjdbc.service;

import java.util.List;

import com.capgemini.forestrymanagementsystembyusingjdbc.bean.UserBean;
import com.capgemini.forestrymanagementsystembyusingjdbc.dao.AdminDAO;
import com.capgemini.forestrymanagementsystembyusingjdbc.exception.LoginException;
import com.capgemini.forestrymanagementsystembyusingjdbc.exception.UserException;
import com.capgemini.forestrymanagementsystembyusingjdbc.factory.Factory;

public class AdminServicesImpl implements AdminServices {
	AdminDAO adminDAO = Factory.instanceOfAdminDAOImpl();

	@Override
	public UserBean login(String username, String password, String role) throws LoginException {

		return adminDAO.login(username, password, role);
	}

	@Override
	public boolean addUser(UserBean UserBean) throws UserException {
		return adminDAO.addUser(UserBean);
	}

	@Override
	public boolean removeUser(String username, String role) throws UserException {
		return adminDAO.removeUser(username, role);
	}

	@Override
	public List<UserBean> showAllUser() throws UserException {
		return adminDAO.showAllUser();
	}

	@Override
	public UserBean searchUser(String username, String role) throws UserException {
		return adminDAO.searchUser(username, role);
	}

	@Override
	public boolean modifyUser(UserBean userBean) throws UserException {
		return adminDAO.modifyUser(userBean);
	}

}
