package com.capgemini.forestrymanagementsystembyusingcollection.service;

import com.capgemini.forestrymanagementsystembyusingcollection.baen.SchedulerBean;
import com.capgemini.forestrymanagementsystembyusingcollection.dao.SchedulerDAO;
import com.capgemini.forestrymanagementsystembyusingcollection.exception.SchedulerException;
import com.capgemini.forestrymanagementsystembyusingcollection.factory.ForestDaoManager;

public class SchedulerServiceImpl implements SchedulerService {
	
	SchedulerDAO dao = ForestDaoManager.instanceofSchedulerDAOImpl();

	@Override
	public boolean insertSchedule(SchedulerBean sch, int schedulerid) throws SchedulerException {
		return dao.insertSchedule(sch, schedulerid);
	}

	@Override
	public void showSchedules() throws SchedulerException {
		dao.showSchedules();

	}

	@Override
	public SchedulerBean viewSchedules(int schedulerid) throws SchedulerException {
		return dao.viewSchedules(schedulerid);
	}

	@Override
	public SchedulerBean schedulerLogin(String username, String password) throws SchedulerException {
		return dao.schedulerLogin(username, password);
	}

}
