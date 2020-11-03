package com.capgemini.forestrymanagementsystembyusingjdbc.controller;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.capgemini.forestrymanagementsystembyusingjdbc.bean.UserBean;
import com.capgemini.forestrymanagementsystembyusingjdbc.exception.InvalidInputException;
import com.capgemini.forestrymanagementsystembyusingjdbc.exception.LoginException;
import com.capgemini.forestrymanagementsystembyusingjdbc.factory.Factory;
import com.capgemini.forestrymanagementsystembyusingjdbc.service.AdminServices;

public class App {

	Scanner sc = new Scanner(System.in);
	boolean loginFlag = false;
	Scanner scn = new Scanner(System.in);
	Validation validObj = new Validation();
	String prompt;

	AdminServices adminservices = Factory.instanceOfAdminServices();

	public void mainOperation() {
		try {
			while (true) {
				System.out.println("Welcome To Forestry Management System");
				System.out.println("Please Select The Role You Want To Login ");
				System.out.println("1.Admin");
				System.out.println("2.Client");
				System.out.println("3.Scheduler");
				String optionSelected = sc.next();
				int options = Integer.parseInt(optionSelected);
				switch (options) {
				case 1:
					Admin admin = new Admin();
					admin.adminOPeration();
					break;
				case 2:
					Client client = new Client();
					client.clientOpeation();
					break;

				case 3:
					SchedulerMain schedulermain = new SchedulerMain();
					schedulermain.schedulerOperation();
					break;
				default:
					System.out.println("Please Select The Options As per the Mentioned Number");
					break;
				}// switch

			} // while
		} catch (NumberFormatException | InputMismatchException e) {
			throw new InvalidInputException("Please Select The Options As per the Mentioned Number");
		}
	} //

	@SuppressWarnings("unused")
	private boolean validateLogin() {

		System.out.println("Please Provide The Below Details To Login :");
		System.out.print("User Name: ");
		String name = null;
		if (scn.hasNextLine()) {
			name = scn.nextLine();
		}

		System.out.print("Password: ");
		String password = null;
		if (scn.hasNextLine()) {
			password = scn.nextLine();
		}

		UserBean adminBean = null;
		try {
			adminBean = adminservices.login(name, password, "admin");
		} catch (LoginException e) {
			System.err.println(e.getMessage());
		}
		if (adminBean != null) {
			String adminName = adminBean.getUserName();
			String adminPassword = adminBean.getPassword();

			if (name.equalsIgnoreCase(adminName) && password.equalsIgnoreCase(adminPassword)) {
				loginFlag = true;
			} else {
				System.err.println("Please Provide The Correct Details To Login");
				loginFlag = false;
			}
		}
		return loginFlag;
	}
}