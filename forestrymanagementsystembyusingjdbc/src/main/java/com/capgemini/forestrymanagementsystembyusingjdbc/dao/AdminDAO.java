package com.capgemini.forestrymanagementsystembyusingjdbc.dao;

import java.util.List;

import com.capgemini.forestrymanagementsystembyusingjdbc.bean.UserBean;
import com.capgemini.forestrymanagementsystembyusingjdbc.exception.LoginException;
import com.capgemini.forestrymanagementsystembyusingjdbc.exception.UserException;

/**
 * 
 * @author Ankita Panda
 *
 */
public interface AdminDAO {
	public UserBean login(String username, String password, String role) throws LoginException;

	public boolean addUser(UserBean UserBean) throws UserException;

	public boolean removeUser(String username, String role) throws UserException;

	public List<UserBean> showAllUser() throws UserException;

	public UserBean searchUser(String username, String role) throws UserException;

	public boolean modifyUser(UserBean userBean) throws UserException;

}
