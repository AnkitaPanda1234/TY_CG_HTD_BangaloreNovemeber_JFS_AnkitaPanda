package com.capgemini.forestrymanagementsystembyusingcollection.service;

import com.capgemini.forestrymanagementsystembyusingcollection.baen.ScheduleBean;

public interface ScheduleService {
	
	public boolean addSchedule(int schedulerid,ScheduleBean schedule);

	

	public ScheduleBean searchSchedule(int scheduleid);

	public ScheduleBean getAllSchedule();



}
