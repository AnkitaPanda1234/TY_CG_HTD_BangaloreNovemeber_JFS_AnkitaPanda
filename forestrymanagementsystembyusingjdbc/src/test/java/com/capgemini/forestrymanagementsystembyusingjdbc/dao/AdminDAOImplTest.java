package com.capgemini.forestrymanagementsystembyusingjdbc.dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.capgemini.forestrymanagementsystembyusingjdbc.bean.LandBean;
import com.capgemini.forestrymanagementsystembyusingjdbc.bean.UserBean;
import com.capgemini.forestrymanagementsystembyusingjdbc.exception.LandException;
import com.capgemini.forestrymanagementsystembyusingjdbc.exception.UserException;

class AdminDAOImplTest {
	AdminDAOImpl obj=null;
	UserBean user=null;
	
	@BeforeEach
	void load() {
		obj = new AdminDAOImpl();
	}




  
  @Test
  void testSearchUser() {
	  user =new UserBean();
		user.setUserName("mama");
		user.setPassword("ankira");
		user.setRole("client");
		try {
			obj.searchUser(user.getUserName(), user.getRole());
			assertEquals(obj,obj);
		}catch(Exception e) {
			assertThrows(LandException.class,()->{
				obj.addUser(user);
			});
		}
	  
	  
  }
  
  @Test
  void testModifyUser() {
	  user =new UserBean();
		user.setUserName("mama");
		user.setPassword("ssss");
		user.setRole("client");
		try {
			boolean flag = obj.modifyUser(user);
			assertEquals(flag, true);

		} catch (Exception e) {
			assertThrows(LandException.class, () -> {
				obj.modifyUser(user);
			});
		}
	}
  
  @Test
  void testLogin() {
	  user =new UserBean();
	  user.setUserName("mama");
	  user.setPassword("ssss");
		user.setRole("client");
		try {
			obj.login(user.getUserName(), user.getPassword(), user.getRole());
			assertEquals(obj, obj);

		} catch (Exception e) {
			assertThrows(LandException.class, () -> {
				obj.login(user.getUserName(), user.getPassword(), user.getRole());
			});
		}
	}

}