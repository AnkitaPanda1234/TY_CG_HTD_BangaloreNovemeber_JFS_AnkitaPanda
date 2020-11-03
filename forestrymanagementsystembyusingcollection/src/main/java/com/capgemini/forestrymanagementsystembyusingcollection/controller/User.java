package com.capgemini.forestrymanagementsystembyusingcollection.controller;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.capgemini.forestrymanagementsystembyusingcollection.dao.ClientDAO;
import com.capgemini.forestrymanagementsystembyusingcollection.dao.ContractorDAO;
import com.capgemini.forestrymanagementsystembyusingcollection.dao.CustomerDAO;
import com.capgemini.forestrymanagementsystembyusingcollection.dao.ProductDAO;
import com.capgemini.forestrymanagementsystembyusingcollection.exception.InvalidInputException;
import com.capgemini.forestrymanagementsystembyusingcollection.exception.LoginException;
import com.capgemini.forestrymanagementsystembyusingcollection.factory.ForestDaoManager;

public class User {
	ClientDAO clientDao = ForestDaoManager.instanceofClientDAOImpl();
	Customer cstMain = new Customer();
	ProductDAO productDao = ForestDaoManager.instanceofProductDAOImpl();
	ContractorDAO contractDao = ForestDaoManager.instanceofContractorDAOImpl();
	CustomerDAO customerdao = ForestDaoManager.instanceofCustomerDAOImpl();
	Scanner sc = new Scanner(System.in);
	Scanner scn = new Scanner(System.in);
	boolean loginFlag = false;
	Validation validObj = new Validation();
	String prompt;

	@SuppressWarnings("static-access")
	public void client() {
		try {
			// System.out.println("Enter the below details for login");
			boolean loginFlag = false;
			try {
				loginFlag = validateLogin();
			} catch (LoginException e) {
				System.err.println("Client Details are not present, Please conatct Admin To Create Client");
			}
			if (loginFlag) {
				while (true) {
					System.out.println("Welcome To Client Page");
					System.out.println("1: Customer");
					System.out.println("2: Hauiler");
					System.out.println("3: Contract");
					System.out.println("4: Return");
					int choice = sc.nextInt();
					switch (choice) {
					case 1:
						Customer cstMain = new Customer();
						cstMain.customer();
						break;
					case 2:
						Hauiler hauilermain = new Hauiler();
						hauilermain.hauiler();
						break;
					case 3:
						Contractor contractmain = new Contractor();
						contractmain.contractor();
						break;
					case 4:
						TestMain testMain = new TestMain();
						testMain.main();
						break;
					default:
						System.out.println("Please Select The Options As per the Mentioned Number");
						break;
					}// switch
				} // while
			} // if
		} catch (NumberFormatException | InputMismatchException | InvalidInputException e) {
			throw new InvalidInputException("Please Select The Options As per the Mentioned Number");
		}
	}// method end

	private boolean validateLogin() {

		System.out.println("Enter The Below Details To Login");
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

	/*	ClientBean clntBean = null;
		try {
			clntBean = clientDao.clientLogin(userName, userPassword);
			if (clntBean != null) {
				String clientName = clntBean.getClientUserName();
				String clientPassword = clntBean.getClientPassword();
				if (clientName.equalsIgnoreCase(userName) && clientPassword.equalsIgnoreCase(userPassword)) {
					return true;
				} else {
					System.err.println("Please Provide The Correct Details To Login");
					return false;
				}
			}
		} catch (LoginException e) {
			System.err.println(e.getMessage());
			TestMain.main();
		}
*/
		if (userName.equalsIgnoreCase("client")
				&& userPassword.equalsIgnoreCase("client@1234")) {
			return true;
		} else {
			throw new LoginException("Please Provide The Correct Credentials For Scheduler Login");
		}
	}
}
