package com.capgemini.forestrymanagementsystembyusingcollection.dao;

import com.capgemini.forestrymanagementsystembyusingcollection.baen.SchedulerBean;
import com.capgemini.forestrymanagementsystembyusingcollection.exception.LoginException;
import com.capgemini.forestrymanagementsystembyusingcollection.exception.SchedulerException;

public interface SchedulerDAO {

	public boolean insertSchedule(SchedulerBean sch, int schedulerid) throws SchedulerException;

	public void showSchedules() throws SchedulerException;

	public SchedulerBean viewSchedules(int schedulerid) throws SchedulerException;

	public SchedulerBean schedulerLogin(String username, String password) throws LoginException;

}
