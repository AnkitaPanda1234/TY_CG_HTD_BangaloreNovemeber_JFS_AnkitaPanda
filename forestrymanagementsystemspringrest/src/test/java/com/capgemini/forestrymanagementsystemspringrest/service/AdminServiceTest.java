package com.capgemini.forestrymanagementsystemspringrest.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.capgemini.forestrymanagementsystemspringrest.config.ORMConfig;
import com.capgemini.forestrymanagementsystemspringrest.dao.AdminDAO;
import com.capgemini.forestrymanagementsystemspringrest.dto.UserBean;
import com.capgemini.forestrymanagementsystemspringrest.testconfig.TestBeans;
@SpringJUnitConfig(classes = { TestBeans.class, ORMConfig.class })
class AdminServiceTest {

	@Autowired
	AdminService adminService;
	@Test
	void testClientregister() {
		UserBean userBean=new UserBean();
		userBean.setUsername("ClntTest");
		userBean.setPassword("client@1234");
		userBean.setRole("client");
		assertTrue(adminService.clientregister(userBean));
		assertTrue(adminService.removeClient(userBean.getId()));
		
	}

	@Test
	void testSchedulerregister() {
		UserBean userBean=new UserBean();
		userBean.setUsername("SchedTest");
		userBean.setPassword("Scheduler@1234");
		userBean.setRole("scheduler");
		assertTrue(adminService.schedulerregister(userBean));
		assertTrue(adminService.removeScheduler(userBean.getId()));
		
	}

	@Test
	void testRemoveClient() {
		UserBean userBean=new UserBean();
		userBean.setUsername("ClntTest");
		userBean.setPassword("client@1234");
		userBean.setRole("client");
		assertTrue(adminService.clientregister(userBean));
		assertTrue(adminService.removeClient(userBean.getId()));
	}

	@Test
	void testShowClients() {
		assertNotNull(adminService.showClients());
	}

	@Test
	void testRemoveScheduler() {
		UserBean userBean=new UserBean();
		userBean.setUsername("SchedTest");
		userBean.setPassword("Scheduler@1234");
		userBean.setRole("scheduler");
		assertTrue(adminService.schedulerregister(userBean));
		assertTrue(adminService.removeScheduler(userBean.getId()));
	}

	@Test
	void testShowScheduler() {
		
		assertNotNull(adminService.showScheduler());
	}
}
