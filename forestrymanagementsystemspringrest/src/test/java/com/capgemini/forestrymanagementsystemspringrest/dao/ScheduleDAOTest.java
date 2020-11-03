package com.capgemini.forestrymanagementsystemspringrest.dao;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.capgemini.forestrymanagementsystemspringrest.config.ORMConfig;
import com.capgemini.forestrymanagementsystemspringrest.dto.ScheduleBean;
import com.capgemini.forestrymanagementsystemspringrest.testconfig.TestBeans;

@SpringJUnitConfig(classes = { TestBeans.class, ORMConfig.class })
class ScheduleDAOTest {

	@Autowired
	ScheduleDAO scheduleDAO;
	@Test
	void testGetAllSchedule() {
		assertNotNull(scheduleDAO.getAllSchedule());
	}
	@Test
	void testAddSchedule() {
		ScheduleBean scheduleBean = new ScheduleBean();
		scheduleBean.setContractId(35);
		scheduleBean.setCustomerId(2);
		scheduleBean.setOrderId(4);
		scheduleBean.setProductId(6);
		scheduleBean.setDeliveryDate("21-12-2020");
		scheduleBean.setStatus("Scheduled");
		assertTrue(scheduleDAO.addSchedule(scheduleBean));
	}

	@Test
	void testSearchSchedule() {
		ScheduleBean scheduleBean = new ScheduleBean();
		scheduleBean.setContractId(35);
		scheduleBean.setCustomerId(2);
		scheduleBean.setOrderId(4);
		scheduleBean.setProductId(6);
		scheduleBean.setDeliveryDate("21-12-2020");
		scheduleBean.setStatus("Scheduled");
		assertTrue(scheduleDAO.addSchedule(scheduleBean));
		assertNotNull(scheduleDAO.searchSchedule(scheduleBean.getScheduleId()));
	}

	

}
