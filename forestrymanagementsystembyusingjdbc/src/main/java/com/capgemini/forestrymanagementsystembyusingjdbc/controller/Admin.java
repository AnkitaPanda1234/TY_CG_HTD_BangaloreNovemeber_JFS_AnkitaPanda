package com.capgemini.forestrymanagementsystembyusingjdbc.controller;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.capgemini.forestrymanagementsystembyusingjdbc.bean.UserBean;
import com.capgemini.forestrymanagementsystembyusingjdbc.exception.InvalidInputException;
import com.capgemini.forestrymanagementsystembyusingjdbc.exception.LoginException;
import com.capgemini.forestrymanagementsystembyusingjdbc.factory.Factory;
import com.capgemini.forestrymanagementsystembyusingjdbc.service.AdminServices;

public class Admin {

	Scanner sc = new Scanner(System.in);
	boolean loginFlag = false;
	Scanner scn = new Scanner(System.in);
	Validation validObj = new Validation();
	String prompt;
	AdminServices adminservices = Factory.instanceOfAdminServices();
	UserBean adminBean = new UserBean();

	public void adminOPeration() {

		try {
			System.out.println("Welome To Admin Page");
			loginFlag = validateLogin();
			if (loginFlag) {
				System.out.println("Successfully Logged In As Admin");
				while (true) {
					System.out.println("Please Select The Module As Per Your Choice:");
					System.out.println("1:Clients");
					System.out.println("2:Products");
					System.out.println("3:Lands");
					System.out.println("4:Reports");
					System.out.println("5:Scheduler");
					System.out.println("6:Return");

					int choice = sc.nextInt();
					switch (choice) {
					case 1:
						// CLIENT CRUD
						ClientMain client = new ClientMain();
						client.clientOperations();
						break;
					case 2:
						InventoryMain inventoryMain = new InventoryMain();
						inventoryMain.inventoryOperation();
						break;
					case 3:
						LandMain landMain = new LandMain();
						landMain.landOperation();
						break;
					case 4:
						ReportsMain reportsMain = new ReportsMain();
						reportsMain.getAllReports();
						break;
					case 5:
						SchedulerMain main = new SchedulerMain();
						main.addScheduler();
						break;

					case 6:
						App app = new App();
						app.mainOperation();
						break;
					default:
						System.out.println("Please Select The Options As per the Mentioned Number");
						break;
					}// ENd OF MAIN SWITCH

				} // while
			} // IF
		} catch (NumberFormatException | InputMismatchException e) {
			throw new InvalidInputException("Please Select The Options As per the Mentioned Number");
		}
	} // End Of Main

	private boolean validateLogin() {

		System.out.println("Please Provide The Below Details To Login As Admin : ");
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
			if (adminName.equalsIgnoreCase(name) && adminPassword.equalsIgnoreCase(password)) {
				return true;
			} else {
				System.err.println("Please Provide The Correct Details To Login");
				return false;
			}
		}
		return false;
	}

}// End Of Class
