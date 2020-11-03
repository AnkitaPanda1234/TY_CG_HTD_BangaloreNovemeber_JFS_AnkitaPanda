package com.capgemini.forestrymanagementsystembyusingjdbc.service;

import java.util.List;

import com.capgemini.forestrymanagementsystembyusingjdbc.bean.ScheduleBean;
import com.capgemini.forestrymanagementsystembyusingjdbc.dao.ScheduleDAO;
import com.capgemini.forestrymanagementsystembyusingjdbc.exception.SchedulerException;
import com.capgemini.forestrymanagementsystembyusingjdbc.factory.Factory;

public class ScheduleServiceImpl implements ScheduleService {
	ScheduleDAO schedulerdao = Factory.instanceOfScheduleDAOImpl();

	@Override
	public boolean addSchedule(ScheduleBean schedule) throws SchedulerException {
		return schedulerdao.addSchedule(schedule);
	}

	@Override
	public ScheduleBean searchSchedule(int schedulerid) throws SchedulerException {
		return schedulerdao.searchSchedule(schedulerid);
	}

	@Override
	public List<ScheduleBean> getAllSchedule() throws SchedulerException {

		return schedulerdao.getAllSchedule();
	}

	@Override
	public boolean updateSchedule(int contractId, String status) throws SchedulerException {
		return schedulerdao.updateSchedule(contractId, status);
	}

	@Override
	public boolean cancelSchedule(int schduleNo) throws SchedulerException {
		return schedulerdao.cancelSchedule(schduleNo);
	}

}
