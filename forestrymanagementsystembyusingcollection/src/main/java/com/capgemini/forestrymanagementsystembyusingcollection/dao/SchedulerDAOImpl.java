package com.capgemini.forestrymanagementsystembyusingcollection.dao;

import java.util.HashMap;

import com.capgemini.forestrymanagementsystembyusingcollection.baen.SchedulerBean;
import com.capgemini.forestrymanagementsystembyusingcollection.exception.LoginException;
import com.capgemini.forestrymanagementsystembyusingcollection.exception.SchedulerException;
public class SchedulerDAOImpl implements SchedulerDAO {
	static HashMap<Integer, SchedulerBean> h1 = new HashMap<Integer, SchedulerBean>();

	@Override
	public boolean insertSchedule(SchedulerBean sch, int schedulerid) throws SchedulerException {

		SchedulerBean schedulerBean = viewSchedules(schedulerid);
		if (schedulerBean != null) {
			throw new SchedulerException("Scheduler Id Already Present,Please Enter a differnt Id");
		} else {
			h1.put(schedulerid, sch);
		}

		if (h1.containsKey(schedulerid)) {
			return true;
		} else {
			return false;
		}

	}

	@SuppressWarnings("unlikely-arg-type")
	@Override
	public SchedulerBean schedulerLogin(String username, String Password) throws LoginException {

		SchedulerBean schedulerBean = null;
		if (h1.containsKey(username)) {
			schedulerBean = h1.get(username);
		}
		if (schedulerBean != null) {
			return schedulerBean;
		} else {
			throw new LoginException("Scheduler Details are not present, Please conatct Admin To Create Scheduler");
		}

	}

	@Override
	public void showSchedules() throws SchedulerException {
		System.out.println(h1);
		
	}

	@Override
	public SchedulerBean viewSchedules(int schedulerid) throws SchedulerException {
		if (h1.containsKey(schedulerid)) {
			return h1.get(schedulerid);
		} else {
			return null;
		}
	}

}
