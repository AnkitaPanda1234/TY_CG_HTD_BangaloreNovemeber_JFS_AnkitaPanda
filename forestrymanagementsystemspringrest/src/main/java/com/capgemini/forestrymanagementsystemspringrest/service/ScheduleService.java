package com.capgemini.forestrymanagementsystemspringrest.service;

import java.util.List;

import com.capgemini.forestrymanagementsystemspringrest.dto.ScheduleBean;
import com.capgemini.forestrymanagementsystemspringrest.exception.SchedulerException;

public interface ScheduleService {
	
	public boolean addSchedule(ScheduleBean schedule);
	
	public ScheduleBean searchSchedule(int schedulerid) throws SchedulerException;

	public List<ScheduleBean> getAllSchedule() throws SchedulerException;

	public boolean deleteSchedule(int scheduleId) throws SchedulerException;
	
	//public boolean modifySchedule(int contractId, String status)throws SchedulerException;

}
