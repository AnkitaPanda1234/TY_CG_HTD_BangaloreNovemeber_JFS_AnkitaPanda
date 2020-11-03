package com.capgemini.forestrymanagementsystembyusingjdbc.service;

import java.util.List;

import com.capgemini.forestrymanagementsystembyusingjdbc.bean.ScheduleBean;
import com.capgemini.forestrymanagementsystembyusingjdbc.exception.SchedulerException;

public interface ScheduleService {
	public boolean addSchedule(ScheduleBean schedule) throws SchedulerException;

	public ScheduleBean searchSchedule(int schedulerid) throws SchedulerException;

	public List<ScheduleBean> getAllSchedule() throws SchedulerException;

	public boolean updateSchedule(int contractId, String status) throws SchedulerException;

	public boolean cancelSchedule(int schduleNo)throws SchedulerException;

}
