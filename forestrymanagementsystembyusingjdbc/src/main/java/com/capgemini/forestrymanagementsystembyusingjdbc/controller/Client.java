package com.capgemini.forestrymanagementsystembyusingjdbc.controller;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.capgemini.forestrymanagementsystembyusingjdbc.bean.UserBean;
import com.capgemini.forestrymanagementsystembyusingjdbc.exception.InvalidInputException;
import com.capgemini.forestrymanagementsystembyusingjdbc.exception.LoginException;
import com.capgemini.forestrymanagementsystembyusingjdbc.factory.Factory;
import com.capgemini.forestrymanagementsystembyusingjdbc.service.AdminServices;

public class Client {

	Scanner sc = new Scanner(System.in);
	boolean loginFlag = false;
	Scanner scn = new Scanner(System.in);
	Validation validObj = new Validation();
	String prompt;
	AdminServices adminservices = Factory.instanceOfAdminServices();

	public void clientOpeation() {

		try {
			System.out.println("Welcome To Client Page");
			System.out.println("Enter the below details for login as Client");
			loginFlag = validateLogin();
			if (loginFlag) {
				while (true) {
					System.out.println("Please Select The Module:");
					System.out.println("1:Customer");
					System.out.println("2:Hauiler");
					System.out.println("3:Contractor");
					System.out.println("4:Return");
					int choice = sc.nextInt();
					switch (choice) {

					case 1:
						CustomerMain customermain = new CustomerMain();
						customermain.customerOperation();
						break;
					case 2:
						HauilerMain hauilermain = new HauilerMain();
						hauilermain.hauilerOperation();
						break;
					case 3:
						ContractorMain contractorMain = new ContractorMain();
						contractorMain.contractOperation();
						break;
					case 4:
						App app = new App();
						app.mainOperation();
						break;
					default:
						System.out.println("Please Select The Options As per the Mentioned Number");
						break;
					}// switch
				} // while
			}
		} catch (NumberFormatException | InputMismatchException e) {
			throw new InvalidInputException("Please Select The Options As per the Mentioned Number");
		}
	}

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
			adminBean = adminservices.login(name, password, "client");
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

}
