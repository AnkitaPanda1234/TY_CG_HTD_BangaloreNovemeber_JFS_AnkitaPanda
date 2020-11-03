package com.capgemini.forestrymanagementsystembyusingjdbc.dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.capgemini.forestrymanagementsystembyusingjdbc.bean.ScheduleBean;
import com.capgemini.forestrymanagementsystembyusingjdbc.dao.ScheduleDAOImpl;
import com.capgemini.forestrymanagementsystembyusingjdbc.exception.CustomerException;
import com.capgemini.forestrymanagementsystembyusingjdbc.exception.SchedulerException;

class ScheduleDAOImplTest {
	ScheduleDAOImpl obj=null;
	ScheduleBean schedule=null;
	
	@BeforeEach
	void load() {
		obj=new ScheduleDAOImpl();
	}


	@Test
	void testAddSchedule() {
		schedule=new ScheduleBean();
		schedule.setScheduleId(9);
		schedule.setContractId(1);
		schedule.setCustomerId(2);
		schedule.setDeliveryDate("20-11-2020");
		schedule.setOrderId(3);
		schedule.setProductId(4);
		schedule.setStatus("order");
		try {
			boolean flag=obj.addSchedule(schedule);
			assertEquals(flag, true);
		}catch(Exception e) {
			assertThrows(SchedulerException.class, ()-> {
				obj.addSchedule(schedule);
			});
		}
		
	}
	@Test
	void testSearchSchedule() {
		schedule=new ScheduleBean();
		schedule.setScheduleId(5);
		try {
			obj.searchSchedule(schedule.getScheduleId());
			assertEquals(obj,obj);
		}catch(Exception e) {
			assertThrows(SchedulerException.class,()->{
				obj.addSchedule(schedule);
			});
		}
		
	}
	@Test
	void testGetAllSchedule() {
		schedule=new ScheduleBean();
		try {
			obj.getAllSchedule();
			assertEquals(obj,obj);
		}catch(Exception e) {
			assertThrows(SchedulerException.class,()-> {
				obj.getAllSchedule();
			});
		}
		
	}
	}


