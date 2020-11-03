package com.capgemini.forestrymanagementsystembyusingjdbc.controller;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.capgemini.forestrymanagementsystembyusingjdbc.bean.UserBean;
import com.capgemini.forestrymanagementsystembyusingjdbc.exception.InvalidInputException;
import com.capgemini.forestrymanagementsystembyusingjdbc.exception.UserException;
import com.capgemini.forestrymanagementsystembyusingjdbc.factory.Factory;
import com.capgemini.forestrymanagementsystembyusingjdbc.service.AdminServices;

public class ClientMain {

	Scanner sc = new Scanner(System.in);
	Scanner scn = new Scanner(System.in);
	Validation validObj = new Validation();
	String prompt;
	AdminServices adminServices = Factory.instanceOfAdminServices();
	boolean loginFlag = false;
	String roleType = "client";

	public void clientOperations() {
		try {
			System.out.println("Client Details");
			while (true) {
				System.out.println("Please Select The Operation:");
				System.out.println("1:Add");
				System.out.println("2:Modify");
				System.out.println("3:Search");
				System.out.println("4:Delete");
				System.out.println("5:Return");
				int choice = sc.nextInt();
				switch (choice) {
				case 1:
					addClient();
					break;
				case 2:
					modifyClient();
					break;
				case 3:
					searchClient();
					break;
				case 4:
					deleteClient();
					break;
				case 5:
					Admin admin = new Admin();
					admin.adminOPeration();
					return;
				default:
					System.out.println("Please Select The Options As per the Mentioned Number");
					break;
				}
			} // while
		} catch (NumberFormatException | InputMismatchException e) {
			throw new InvalidInputException("Please Select The Options As per the Mentioned Number");
		}

	}

	private void deleteClient() {

		System.out.println("Enter The Below Details To Delete Client");
		String name = null;
		do {
			System.out.print("User Name:");
			if (scn.hasNextLine()) {
				name = scn.nextLine();
			}
			prompt = "\nUser name should contain only letters.\n";
			if (!validObj.nameValidation(name)) {
				System.err.println(prompt);
			}

		} while (!validObj.nameValidation(name));

		boolean flag = false;
		try {
			flag = adminServices.removeUser(name, roleType);
			if (flag) {
				System.out.println("Client Details Deleted Sucessfuly");
			}
		} catch (UserException e) {
			System.err.println(e.getMessage());
		}
	}

	private void searchClient() {
		System.out.println("Enter The Below Details To View Client");
		String name = null;
		do {
			System.out.print("User Name:");
			if (scn.hasNextLine()) {
				name = scn.nextLine();
			}
			// name = scn.next();
			prompt = "\nUser name should contain only letters.\n";
			if (!validObj.nameValidation(name)) {
				System.err.println(prompt);
			}

		} while (!validObj.nameValidation(name));

		UserBean userBean;
		try {
			userBean = adminServices.searchUser(name, roleType);
			if (userBean != null) {
				System.out.println(userBean);
			} else {
				System.out.println("Client Details Not Found For the Given Name");
			}
		} catch (UserException e) {
			System.err.println(e.getMessage());
		}

	}

	private void modifyClient() {
		System.out.println("Enter The Below Details To Update Client");

		UserBean userBean = getUserInput();

		boolean updateFlag = false;
		try {
			updateFlag = adminServices.modifyUser(userBean);
			if (updateFlag) {
				System.out.println("Client Details Modified Successfully");
			}
		} catch (UserException e2) {
			System.err.println(e2.getMessage());
		}
	}

	public void addClient() {
		System.out.println("Enter The Below Details : ");

		UserBean userBean = getUserInput();

		boolean addFlag = false;
		try {
			addFlag = adminServices.addUser(userBean);
			if (addFlag) {
				System.out.println(userBean.getRole() + "  Details Added Successfully");
			}
		} catch (UserException e) {
			System.err.println(e.getMessage());
		}

	}

	private UserBean getUserInput() {

		UserBean userBean = new UserBean();

		String name = null;
		do {
			System.out.print("User Name:");
			if (scn.hasNextLine()) {
				name = scn.nextLine();
			}
			// name = scn.next();
			prompt = "\nUser name should contain only letters.\n";
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
				System.err.println(prompt);
			}
		} while (!validObj.passwordValidation(password));
		userBean.setUserName(name);
		userBean.setPassword(password);
		userBean.setRole(roleType);
		return userBean;
	}

}
