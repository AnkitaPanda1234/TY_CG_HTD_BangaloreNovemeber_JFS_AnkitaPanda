package com.capgemini.forestrymanagementsystembyusingcollection.controller;

import java.util.Scanner;

import com.capgemini.forestrymanagementsystembyusingcollection.baen.SchedulerBean;
import com.capgemini.forestrymanagementsystembyusingcollection.dao.ContractorDAO;
import com.capgemini.forestrymanagementsystembyusingcollection.dao.SchedulerDAO;
import com.capgemini.forestrymanagementsystembyusingcollection.exception.LoginException;
import com.capgemini.forestrymanagementsystembyusingcollection.exception.SchedulerException;
import com.capgemini.forestrymanagementsystembyusingcollection.factory.ForestDaoManager;



public class SchedulerMain {
	static SchedulerDAO dao = ForestDaoManager.instanceofSchedulerDAOImpl();
	Validation validObj = new Validation();
	String prompt;
	boolean loginFlag = false;
	Scanner sc = new Scanner(System.in);
	Scanner scn = new Scanner(System.in);

	static ContractorDAO contractorDAO = ForestDaoManager.instanceofContractorDAOImpl();

	public void schedueDetails() {
		loginFlag = validateLogin();
		if (loginFlag) {
			try {
				Schedule schedule = new Schedule();
				schedule.ScheduleOperation();
			} catch (SchedulerException e) {
				System.out.println(e.getMessage());
			}

		} // end of login if

	}

	@SuppressWarnings("unused")
	public void addScheduler() {

		boolean addFlag = false;
		SchedulerBean schedulerbean = getSchedulerDetails();

		try {

			addFlag = dao.insertSchedule(schedulerbean, schedulerbean.getId());
			if (addFlag) {
				System.out.println("Scheduler Details Added Successfully");
			}
		} catch (SchedulerException e2) {
			System.err.println(e2.getMessage());
		}

	}

	@SuppressWarnings("static-access")
	private SchedulerBean getSchedulerDetails() {

		System.out.println("Enter The Below Details To Add Scheduler");
		SchedulerBean schedulerBean = new SchedulerBean();
		String id;
		do {
			System.out.print(" Id:");
			id = sc.next();
			prompt = "\n Schedule Id should conatin only numbers.\n";
			if (!validObj.idValidation(id)) {
				System.err.println(prompt);
			}
		} while (!validObj.idValidation(id));

		String name = null;
		do {
			System.out.print("User Name:");
			if (scn.hasNextLine()) {
				name = scn.nextLine();
			}
			prompt = "\n User name should contain only letters.\n";
			if (!validObj.nameValidation(name)) {
				System.err.println(prompt);
			}

		} while (!validObj.nameValidation(name));

		String password = null;
		do {
			System.out.print("Password:");
			if (scn.hasNextLine()) {
				password = scn.nextLine();
			}
			prompt = "Invalid Password.Password Must Contain 8-40 Characters,Including Upper/Lower Case and One Special Character\n";
			if (!validObj.passwordValidation(password)) {
				System.err.println(prompt);
			}

		} while (!validObj.passwordValidation(password));
		String role = null;
		do {
			System.out.print("User Role:");
			if (scn.hasNextLine()) {
				role = scn.nextLine();
			}
			prompt = "\nRole should contain only letters.\n";
			if (!validObj.nameValidation(role)) {
				System.err.println(prompt);
			}
		} while (!validObj.nameValidation(role));

		schedulerBean.setUserName(name);
		schedulerBean.setPassword(password);
		schedulerBean.setRole(role);
		schedulerBean.setId(Integer.parseInt(id));
		return schedulerBean;

	}

	// Log In
	private boolean validateLogin() {

		System.out.println("Provide The Below Details To Login ");
		String userName = null;
		String userPassword = null;

		System.out.print("Name : ");
		if (scn.hasNextLine()) {
			userName = scn.nextLine();
		}
		System.out.print("Password: ");
		if (scn.hasNextLine()) {
			userPassword = scn.nextLine();
		}

		/*
		 * SchedulerBean schedulerBean = null; try { schedulerBean =
		 * dao.schedulerLogin(userName, userPassword); if (schedulerBean != null) {
		 * String clientName = schedulerBean.getUserName(); String clientPassword =
		 * schedulerBean.getPassword(); if (clientName.equalsIgnoreCase(userName) &&
		 * clientPassword.equalsIgnoreCase(userPassword)) { return true; } else {
		 * System.err.println("Please Provide The Correct Details To Login"); return
		 * false; } } } catch (LoginException e) { System.err.println(e.getMessage());
		 * TestMain.main(); }
		 * 
		 * return loginFlag;
		 */

		if (userName.equalsIgnoreCase("scheduler") && userPassword.equalsIgnoreCase("scheduler@1234")) {
			return true;
		} else {
			throw new LoginException("Please Provide The Correct Credentials For Scheduler Login");
		}
	}

}// Main
