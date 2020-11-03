package com.capgemini.forestrymanagementsystembyusingjdbc.controller;

import java.util.Scanner;

import com.capgemini.forestrymanagementsystembyusingjdbc.bean.SchedulerBean;
import com.capgemini.forestrymanagementsystembyusingjdbc.bean.UserBean;
import com.capgemini.forestrymanagementsystembyusingjdbc.exception.LoginException;
import com.capgemini.forestrymanagementsystembyusingjdbc.exception.UserException;
import com.capgemini.forestrymanagementsystembyusingjdbc.factory.Factory;
import com.capgemini.forestrymanagementsystembyusingjdbc.service.AdminServices;
import com.capgemini.forestrymanagementsystembyusingjdbc.service.ContractorServices;
import com.capgemini.forestrymanagementsystembyusingjdbc.service.InventoryServices;

public class SchedulerMain {

	ContractorServices contractorServices = Factory.instanceOfContractorServices();
	InventoryServices productservices = Factory.instanceOfInventoryServices();
	Scanner sc = new Scanner(System.in);
	Scanner scn = new Scanner(System.in);
	Validation validObj = new Validation();
	String prompt;
	SchedulerBean scheduler = new SchedulerBean();
	boolean loginFlag = false;
	String roleType = "scheduler";
	AdminServices adminServices = Factory.instanceOfAdminServices();

	public void schedulerOperation() {

		System.out.println("Scheduler Details");
		System.out.println("Enter the below details for login as Scheduler");
		loginFlag = validateLogin();
		if (loginFlag) {
			Schedule schedule = new Schedule();
			schedule.scheduleOperation();
		}
	}

	private boolean validateLogin() {

		System.out.println("Please Provide The Below Details To Login :");

		System.out.print("User Name:");
		String name = scn.nextLine();

		System.out.print("Password:");
		String password = scn.nextLine();

		UserBean userBean = null;
		try {
			userBean = adminServices.login(name, password, "scheduler");
		} catch (LoginException e) {
			System.err.println(e.getMessage());
		}
		if (userBean != null) {
			String schedulername = userBean.getUserName();
			String schedulerPassword = userBean.getPassword();
			if (schedulername.equalsIgnoreCase(name) && schedulerPassword.equalsIgnoreCase(password)) {
				return true;
			} else {
				System.out.println("Login Failed , Your user name and/or password do not match");
				return false;
			}
		} else {
			return false;
		}
	}

	public void addScheduler() {
		System.out.println("Enter The Below Details To Add Scheduler");

		UserBean userBean = getSchedulerInput();

		boolean addFlag = false;
		try {
			addFlag = adminServices.addUser(userBean);
			if (addFlag) {
				System.out.println("Scheduler  Details Added Successfully");
			}
		} catch (UserException e) {
			System.err.println(e.getMessage());
		}

	}

	private UserBean getSchedulerInput() {

		UserBean userBean = new UserBean();

		String name = null;
		do {
			System.out.print("User Name:");
			if (scn.hasNextLine()) {
				name = scn.nextLine();
			}
			// name = scn.next();
			prompt = "\nScheduler name should contain only letters.\n";
			if (!validObj.nameValidation(name)) {
				System.out.println(prompt);
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
				System.out.println(prompt);
			}

		} while (!validObj.passwordValidation(password));


		userBean.setUserName(name);
		userBean.setPassword(password);
		userBean.setRole("scheduler");
		return userBean;
	}

}
