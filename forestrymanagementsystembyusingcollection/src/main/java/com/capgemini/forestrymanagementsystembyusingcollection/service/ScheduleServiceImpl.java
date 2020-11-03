package com.capgemini.forestrymanagementsystembyusingcollection.service;

import com.capgemini.forestrymanagementsystembyusingcollection.baen.ScheduleBean;
import com.capgemini.forestrymanagementsystembyusingcollection.dao.ScheduleDAO;
import com.capgemini.forestrymanagementsystembyusingcollection.factory.ForestDaoManager;

public class ScheduleServiceImpl implements ScheduleService {

	
	ScheduleDAO scheduledao = ForestDaoManager.instanceofScheduleDAOImpl();
	@Override
	public boolean addSchedule(int schedulerid,ScheduleBean schedule) {
		
		return scheduledao.addSchedule(schedulerid, schedule);
	}

	@Override
	public ScheduleBean getAllSchedule() {
		return scheduledao.getAllSchedule();
	}

	@Override
	public ScheduleBean searchSchedule(int scheduleid) {
		return scheduledao.searchSchedule(scheduleid);
	}

	


}
