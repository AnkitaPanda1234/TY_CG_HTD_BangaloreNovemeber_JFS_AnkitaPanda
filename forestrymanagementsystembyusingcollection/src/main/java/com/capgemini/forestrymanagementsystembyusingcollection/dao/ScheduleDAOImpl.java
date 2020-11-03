package com.capgemini.forestrymanagementsystembyusingcollection.dao;

import java.util.HashMap;

import com.capgemini.forestrymanagementsystembyusingcollection.baen.ScheduleBean;
import com.capgemini.forestrymanagementsystembyusingcollection.exception.SchedulerException;

public class ScheduleDAOImpl implements ScheduleDAO {
	static HashMap<Integer, ScheduleBean> h1 = new HashMap<Integer, ScheduleBean>();
	@Override
	public boolean addSchedule(int schedulerid,ScheduleBean schedule) {
		ScheduleBean scheduleBean = searchSchedule(schedulerid);
		if (scheduleBean != null) {
			throw new SchedulerException("Scheduler Id Already Present,Please Enter a differnt Id");
		} else {
			h1.put(schedulerid, schedule);
		}

		if (h1.containsKey(schedulerid)) {
			return true;
		} else {
			return false;
		}

	}
	

	@Override
	public ScheduleBean searchSchedule(int schedulerid) {
		if (h1.containsKey(schedulerid)) {
			return h1.get(schedulerid);
		} else {
			return null;
		}
	}
	

	@Override
	public ScheduleBean getAllSchedule() {
		if (!h1.isEmpty()) {
			System.out.println(h1);
		} else {
			throw new SchedulerException("Schedule Deatils Are not Present");
		}
		return null;
	}



}
