package com.capgemini.forestrymanagementsystembyusingcollection.controller;

import java.util.Scanner;

import com.capgemini.forestrymanagementsystembyusingcollection.baen.ClientBean;
import com.capgemini.forestrymanagementsystembyusingcollection.dao.ClientDAO;
import com.capgemini.forestrymanagementsystembyusingcollection.exception.ClientException;
import com.capgemini.forestrymanagementsystembyusingcollection.factory.ForestDaoManager;

public class Client {
	ClientDAO clientdao = ForestDaoManager.instanceofClientDAOImpl();
	Scanner sc = new Scanner(System.in);
	Scanner scn = new Scanner(System.in);
	Validation validObj = new Validation();
	String prompt;
	boolean loginFlag = false;
	String roleType = "client";

	public void clientOperation() {
		while (true) {
			System.out.println("Welcome to Client page"); // By Admin
			System.out.println("Please Select The Operation As Per Your Choice:");
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
				modifyclient();
				break;
			case 3:
				searchClient();
				break;
			case 4:
				deleteClient();
				break;
			case 5:
				TestMain.main();
				return;
			default:
				System.err.println("Please Select The Options As per the Mentioned Number");
				break;
			}

		} // while

	}

	private void deleteClient() {

		boolean deletFlag = false;
		System.out.println("Enter The Below Details To Delete Client");
		String id;
		do {
			System.out.print(" Id:");
			id = sc.next();
			prompt = "\nId should conatin only numbers.\n";
			if (!validObj.idValidation(id)) {
				System.err.println(prompt);
			}
		} while (!validObj.idValidation(id));

		int clientId = Integer.parseInt(id);
		try {
			deletFlag = clientdao.deleteClient(clientId);
			if (deletFlag) {
				System.out.println("Client Details Deleted");
			} else {
				System.err.println("Client Details Not Found To Delete");
			}
		} catch (ClientException e) {
			System.err.println(e.getMessage());
		}
	}

	private void searchClient() {

		System.out.println("Enter The Below Details To View Client Details");
		String id;
		do {
			System.out.print(" Id:");
			id = sc.next();
			prompt = "\nId should conatin only numbers.\n";
			if (!validObj.idValidation(id)) {
				System.err.println(prompt);
			}
		} while (!validObj.idValidation(id));

		try {
			ClientBean clientBean = clientdao.searchClient(Integer.parseInt(id));
			if (clientBean != null) {
				System.out.println(clientBean);
			} else {
				System.err.println("Client Details Not Found To View");
			}
		} catch (ClientException e) {
			System.err.println(e.getMessage());
		}
	}

	private void modifyclient() {

		System.out.println("Enter The Below Details To Update Client");
		ClientBean clientBean = getClientInput();
		int id = clientBean.getId();
		boolean updateFlag = false;
		try {
			updateFlag = clientdao.modifyClient(id, clientBean);
			if (updateFlag) {
				System.out.println("Client Details Updated Successfully");
			}

		} catch (ClientException e) {
			System.err.println(e.getMessage());
		}
	}

	private void addClient() {

		System.out.println("Enter The Below Details To Add  Client");
		ClientBean clientBean = getClientInput();
		int id = clientBean.getId();

		boolean addFlag = false;
		try {
			addFlag = clientdao.addClient(id, clientBean);
			if (addFlag) {
				System.out.println("Client Details Added Successfully");
			}
		} catch (ClientException e) {
			System.err.println(e.getMessage());
		}

	}

	private ClientBean getClientInput() {

		ClientBean clientBean = new ClientBean();
		String id;
		do {
			System.out.print("Id:");
			id = sc.next();
			prompt = "\nId should conatin only numbers.\n";
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

			prompt = "\nUsername should contain only letters.\n";
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

			prompt = "Invalid Password. \n"
					+ "Password Must Contain 8-40 Characters,Including Upper/Lower Case and One Special Character\n";
			if (!validObj.passwordValidation(password)) {
				System.err.println(prompt);
			}

		} while (!validObj.passwordValidation(password));

		String role = null;
		do {
			System.out.print("Role:");
			if (scn.hasNextLine()) {
				role = scn.nextLine();
			}
			prompt = "\nRole should contain only letters.\n";
			if (!validObj.nameValidation(role)) {
				System.err.println(prompt);
			}
		} while (!validObj.nameValidation(role));

		clientBean.setId(Integer.parseInt(id));
		clientBean.setClientUserName(name);
		clientBean.setClientPassword(password);
		clientBean.setRole(role);

		return clientBean;
	}

}
