package com.capgemini.forestrymanagementsystembyusingcollection.controller;

import java.util.InputMismatchException;

import java.util.Scanner;

import com.capgemini.forestrymanagementsystembyusingcollection.dao.AdminDAO;
import com.capgemini.forestrymanagementsystembyusingcollection.exception.InvalidInputException;
import com.capgemini.forestrymanagementsystembyusingcollection.exception.LoginException;
import com.capgemini.forestrymanagementsystembyusingcollection.factory.ForestDaoManager;



public class Admin {
	static AdminDAO dao = ForestDaoManager.instanceofAdminDAOImpl();
	Scanner sc = new Scanner(System.in);
	boolean loginFlag = false;
	Scanner scn = new Scanner(System.in);
	Validation validObj = new Validation();
	String prompt;

	@SuppressWarnings("static-access")
	public void adminMain() {

		System.out.println("Enter the below details for Admin  login");

		loginFlag = validateLogin();

		if (loginFlag) {
			while (true) {
				System.out.println("Welcome To Admin Page");
				System.out.println("Please Select The Module As Per Your Choice:");
				System.out.println("1.Clients");
				System.out.println("2:Products");
				System.out.println("3:Lands");
				System.out.println("4.Scheduler");
				System.out.println("5:Reports");
				System.out.println("6:Return");
				try {
					int mainChoice = sc.nextInt();
					switch (mainChoice) {
					case 1:
						Client clientDetails = new Client();
						clientDetails.clientOperation();
						break;
					case 2:
						Product prdMain = new Product();
						prdMain.product();
						break;
					case 3:
						Land lndMain = new Land();
						lndMain.landMain();
						break;
					case 4:
						SchedulerMain main = new SchedulerMain();
						main.addScheduler();
						break;

					case 5:
						Reports reportsMain = new Reports();
						reportsMain.reportsMain();
						break;
					case 6:
						TestMain testMain = new TestMain();
						testMain.main();
						break;
					default:
						System.err.println("Please Select The Options As per the Mentioned Number");
						break;

					}// end of switch

				} // try
				catch (NumberFormatException | InputMismatchException | InvalidInputException e) {
					throw new InvalidInputException("Please Select The Options As per the Mentioned Number");
				} // catch
			} // while
		} // IF

	}// End Of Method

	private boolean validateLogin() {

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

		try {
			loginFlag = dao.adminLogin(userName, userPassword);

		} catch (LoginException e) {
			System.err.println(e.getMessage());
			TestMain.main();
		}

		return loginFlag;
	}
}
