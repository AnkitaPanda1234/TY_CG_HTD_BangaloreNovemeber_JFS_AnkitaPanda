package com.capgemini.forestrymanagementsystemspringrest.dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.capgemini.forestrymanagementsystemspringrest.config.ORMConfig;
import com.capgemini.forestrymanagementsystemspringrest.dto.UserBean;
import com.capgemini.forestrymanagementsystemspringrest.testconfig.TestBeans;
@SpringJUnitConfig(classes = { TestBeans.class, ORMConfig.class })
class AdminDAOTest {

	@Autowired
	AdminDAO adminDAO;
	@Test
	void testClientregister() {
		UserBean userBean=new UserBean();
		userBean.setUsername("ClientTest");
		userBean.setPassword("client@1234");
		userBean.setRole("client");
		assertTrue(adminDAO.clientregister(userBean));
		
	}

	@Test
	void testSchedulerregister() {
		UserBean userBean=new UserBean();
		userBean.setUsername("SchedulerTest");
		userBean.setPassword("Scheduler@1234");
		userBean.setRole("scheduler");
		assertTrue(adminDAO.schedulerregister(userBean));
		
	}



	@Test
	void testShowClients() {
		assertNotNull(adminDAO.showClients());
	}

	

	@Test
	void testShowScheduler() {
		assertNotNull(adminDAO.showScheduler());
	}

}
