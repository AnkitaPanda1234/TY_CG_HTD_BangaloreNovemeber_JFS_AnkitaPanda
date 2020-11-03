package com.capgemini.forestrymanagementsystemspringrest.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.NoResultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.forestrymanagementsystemspringrest.dto.LandResponse;
import com.capgemini.forestrymanagementsystemspringrest.dto.ScheduleBean;
import com.capgemini.forestrymanagementsystemspringrest.dto.ScheduleResponse;
import com.capgemini.forestrymanagementsystemspringrest.exception.LandException;
import com.capgemini.forestrymanagementsystemspringrest.service.ScheduleService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", allowCredentials = "true")
public class ScheduleController {
	@Autowired
	private ScheduleService service;

	@PostMapping(path = "/addschedule", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ScheduleResponse register(@RequestBody ScheduleBean bean) {

		ScheduleResponse response = new ScheduleResponse();
		if (service.addSchedule(bean)) {
			List<ScheduleBean> sclList = new ArrayList<ScheduleBean>();
			sclList.add(bean);
			response.setStatusCode(201);
			response.setMessage("Sucess");
			response.setDescription("Scheduled Added Sucessfully");
			response.setBeans(sclList);

		} else {
			response.setStatusCode(401);
			response.setMessage("failure");
			response.setDescription("Scheduled already exit");
		}

		return response;
	}

	@GetMapping(path = "/searchschedule", produces = MediaType.APPLICATION_JSON_VALUE)
	public ScheduleResponse getSchedule(@RequestParam("scheduleId") int scheduleId) {
		ScheduleResponse response = new ScheduleResponse();

		ScheduleBean bean = null;

		try {
			bean = service.searchSchedule(scheduleId);
		} catch (NoResultException e) {
			System.out.println(e.getMessage());
		}

		if (bean == null) {
			response.setStatusCode(401);
			response.setMessage("failuer");
			response.setDescription("Schedule With Contract Id:" + scheduleId + " Not Present ");

		} else {
			List<ScheduleBean> sclList = new ArrayList<ScheduleBean>();
			sclList.add(bean);

			response.setStatusCode(201);
			response.setMessage("success");
			response.setDescription("Schedule Details Found");
			response.setBeans(sclList);

		}
		return response;
	}

	@GetMapping(path = "/getAllschedule", produces = MediaType.APPLICATION_JSON_VALUE)
	public ScheduleResponse getAllSchedule() {
		ScheduleResponse response = new ScheduleResponse();

		List<ScheduleBean> schedulerList = null;

		try {
			schedulerList = service.getAllSchedule();
		} catch (NoResultException e) {
			System.out.println(e.getMessage());
		}

		if (schedulerList.isEmpty()) {
			response.setStatusCode(401);
			response.setMessage("failuer");
			response.setDescription("Sorry,Currently There is no Product is Scheduled");

		} else {
			response.setStatusCode(201);
			response.setMessage("success");
			response.setDescription("Schedule Details :");
			response.setBeans(schedulerList);

		}
		return response;
	}

	@DeleteMapping(path = "/deleteSchedule/{scheduleId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public LandResponse deleteSchedule(@PathVariable("scheduleId") int scheduleId) {
		LandResponse response = new LandResponse();

		boolean deleteFlag = false;
		try {
			deleteFlag = service.deleteSchedule(scheduleId);
		} catch (LandException e) {
			System.out.println(e.getMessage());
		}

		if (deleteFlag) {
			response.setStatusCode(201);
			response.setMessage("success");
			response.setDescription("Schedule Details Deleted");
		} else {
			response.setStatusCode(401);
			response.setMessage("failuer");
			response.setDescription("Sorry, Not able to Delete Schedule ");
		}
		return response;

	}
}
