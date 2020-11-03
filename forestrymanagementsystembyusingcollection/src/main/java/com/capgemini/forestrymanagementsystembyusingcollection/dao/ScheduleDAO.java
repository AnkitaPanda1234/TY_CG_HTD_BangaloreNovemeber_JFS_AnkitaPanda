package com.capgemini.forestrymanagementsystembyusingcollection.dao;

import com.capgemini.forestrymanagementsystembyusingcollection.baen.ScheduleBean;

public interface ScheduleDAO {
	public boolean addSchedule(int schedulerid, ScheduleBean schedule);

	public ScheduleBean searchSchedule(int scheduleid);

	public ScheduleBean getAllSchedule();

}
