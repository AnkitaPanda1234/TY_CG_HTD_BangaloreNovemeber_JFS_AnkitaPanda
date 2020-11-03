package com.capgemini.forestrymanagementsystembyusingcollection.service;

import com.capgemini.forestrymanagementsystembyusingcollection.baen.SchedulerBean;
import com.capgemini.forestrymanagementsystembyusingcollection.exception.LoginException;
import com.capgemini.forestrymanagementsystembyusingcollection.exception.SchedulerException;

public interface SchedulerService {

	public boolean insertSchedule(SchedulerBean sch, int schedulerid) throws SchedulerException;

	public void showSchedules() throws SchedulerException;

	public SchedulerBean viewSchedules(int schedulerid) throws SchedulerException;

	public SchedulerBean schedulerLogin(String username, String password) throws LoginException;

}
