package com.capgemini.forestrymanagementsystembyusingcollection.dao;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.capgemini.forestrymanagementsystembyusingcollection.baen.ScheduleBean;
import com.capgemini.forestrymanagementsystembyusingcollection.exception.CustomerException;

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
		schedule.setContractId(1);
		schedule.setCustomerid(2);
		schedule.setDeliveryDate("20-11-2020");
		schedule.setOrderId(3);
		schedule.setProductId(4);
		schedule.setSchedulerId(5);
		schedule.setSchedulerId(6);
		schedule.setStatus("order");
		try {
			boolean flag=obj.addSchedule(schedule.getSchedulerId(), schedule);
			assertEquals(flag, true);
		}catch(Exception e) {
			assertThrows(CustomerException.class, ()-> {
				obj.addSchedule(schedule.getSchedulerId(), schedule);
			});
		}
		
	}
	@Test
	void testSearchSchedule() {
		schedule=new ScheduleBean();
		schedule.setSchedulerId(5);
		try {
			obj.searchSchedule(schedule.getSchedulerId());
			assertEquals(obj,obj);
		}catch(Exception e) {
			assertThrows(CustomerException.class,()->{
				obj.addSchedule(schedule.getSchedulerId(), schedule);
			});
		}
		
	}
	
	}


