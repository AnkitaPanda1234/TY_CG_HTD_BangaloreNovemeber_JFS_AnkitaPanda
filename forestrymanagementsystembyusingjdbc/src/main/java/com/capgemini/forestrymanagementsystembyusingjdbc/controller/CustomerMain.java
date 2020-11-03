package com.capgemini.forestrymanagementsystembyusingjdbc.controller;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.capgemini.forestrymanagementsystembyusingjdbc.bean.CustomerBean;
import com.capgemini.forestrymanagementsystembyusingjdbc.exception.CustomerException;
import com.capgemini.forestrymanagementsystembyusingjdbc.exception.InvalidInputException;
import com.capgemini.forestrymanagementsystembyusingjdbc.factory.Factory;
import com.capgemini.forestrymanagementsystembyusingjdbc.service.CustomerServices;

public class CustomerMain {

	CustomerServices services = Factory.instanceOfCustomerServices();
	CustomerBean user = new CustomerBean();
	Scanner sc = new Scanner(System.in);
	Scanner scn = new Scanner(System.in);
	Validation validObj = new Validation();
	String prompt;
	boolean loginFlag = false;

	public void customerOperation() {
		try {
			System.out.println("Welcome To Customer Page");
			while (true) {
				System.out.println("Please Select The Operation You want to Perform");
				System.out.println("1.Add");
				System.out.println("2.Update");
				System.out.println("3.View");
				System.out.println("4.Delete");
				System.out.println("5.Back");

				int choice = sc.nextInt();
				switch (choice) {
				case 1:
					addCustomer();
					break;
				case 2:
					updateCustomer();
					break;
				case 3:
					viewCustomer();
					break;
				case 4:
					deleteCustomer();
					break;
				case 5:
					App app = new App();
					app.mainOperation();
					break;
				default:
					System.out.println("Please Select The Options As per the Mentioned Number");
					break;
				}

			}
		} catch (NumberFormatException | InputMismatchException e) {
			throw new InvalidInputException("Please Select The Options As per the Mentioned Number");
		}
	}// Method

	private void deleteCustomer() {

		String cstid;
		int customerid;
		do {
			System.out.println("Enter the Customer ID you want to delete");
			cstid = sc.next();
			prompt = "\nCustomer Id should conatin only numbers.\n";
			if (!validObj.idValidation(cstid)) {
				System.out.println(prompt);
			}

		} while (!validObj.idValidation(cstid));
		customerid = Integer.parseInt(cstid);

		boolean deleteFlag = false;
		try {
			deleteFlag = services.deleteCustomer(customerid);
			if (deleteFlag) {
				System.out.println("Customer Details Deleted Successfully");
			}
		} catch (CustomerException e) {
			System.out.println(e.getMessage());
		}
	}

	private void viewCustomer() {

		int cstSerchid;
		String cstSrchId;
		CustomerBean cstBean = null;
		do {
			System.out.println("Enter the Customer Id To View The Customer Details");
			cstSrchId = sc.next();
			prompt = "\nCustomer Id should conatin only numbers.\n";
			if (!validObj.idValidation(cstSrchId)) {
				System.out.println(prompt);
			}

		} while (!validObj.idValidation(cstSrchId));

		cstSerchid = Integer.parseInt(cstSrchId);
		try {
			cstBean = services.viewCustomer(cstSerchid);
			if (cstBean != null) {
				System.out.println(cstBean);
			} else {
				System.out.println("Customer Details Not Present");
			}
		} catch (CustomerException e) {
			System.out.println(e.getMessage());
		}

	}

	private void updateCustomer() {

		System.out.println("Enter The Below Details To Update Customer");

		boolean updateFlag = false;
		try {
			CustomerBean cstBean = getCustomerInfoInput();
			int cstId = cstBean.getCustomerid();
			updateFlag = services.modifyCustomer(cstId, cstBean);
			if (updateFlag) {
				System.out.println("Customer Details Modified Successfully");
			}
		} catch (CustomerException e) {
			System.out.println(e.getMessage());
		}

	}

	private void addCustomer() {

		System.out.println("Enter The Below Details To Add Customer");

		boolean addFlag = false;
		try {
			CustomerBean cstBean = getCustomerInfoInput();
			addFlag = services.addCustomer(cstBean);
			if (addFlag) {
				System.out.println("Customer Details Added Successfully");
			}
		} catch (CustomerException e) {
			System.out.println(e.getMessage());
		}
	}

	public CustomerBean getCustomerInfoInput() {

		CustomerBean customerBean = new CustomerBean();
		String customerid;
		do {
			System.out.print("Customer Id:");
			customerid = sc.next();
			prompt = "\nCustomer Id should conatin only numbers.\n";
			if (!validObj.idValidation(customerid)) {
				System.out.println(prompt);
			}
		} while (!validObj.idValidation(customerid));

		customerBean.setCustomerid(Integer.parseInt(customerid));

		String name = null;

		do {
			System.out.print("Customer Name:");
			if (scn.hasNextLine()) {
				name = scn.nextLine();
			}
			// name = scn.next();
			prompt = "\nCustomer name should contain only letters.\n";
			if (!validObj.nameValidation(name)) {
				System.out.println(prompt);
			}

		} while (!validObj.nameValidation(name));
		customerBean.setCustomerName(name);

		String address1 = null;
		do {
			System.out.println("Address1:");
			if (scn.hasNextLine()) {
				address1 = scn.nextLine();
			}
			prompt = "\nPlease enter a valid address for address1.\n";
			if (!validObj.addresValidation(address1)) {
				System.out.println(prompt);
			}
		} while (!validObj.addresValidation(address1));

		customerBean.setStreetAddress1(address1);

		String address2 = null;
		do {
			System.out.println("Enter Address2:");
			if (scn.hasNextLine()) {
				address2 = scn.nextLine();
			}
			// address2 = sc.next();
			prompt = "\nPlease enter a valid address for address2.\n";
			if (!validObj.addresValidation(address2)) {
				System.out.println(prompt);
			}
		} while (!validObj.addresValidation(address2));

		customerBean.setStreetAddress2(address2);

		String town = null;
		do {
			System.out.println("Town:");
			// town = sc.next();
			if (scn.hasNextLine()) {
				town = scn.nextLine();
			}
			prompt = "\n Town should contain only letters.\n";
			if (!validObj.townValidation(town)) {
				System.out.println(prompt);
			}
		} while (!validObj.townValidation(town));

		customerBean.setTown(town);

		int postalcode;
		do {
			System.out.println("Postal Code:");
			postalcode = sc.nextInt();
			prompt = "\n Postal code must contain 6 digit numbers.\n";
			if (!validObj.postalCodeValidation(postalcode)) {
				System.out.println(prompt);
			}
		} while (!validObj.postalCodeValidation(postalcode));

		customerBean.setPostalCode(postalcode);

		String email;
		do {
			System.out.println("Email ID");
			email = sc.next();
			prompt = "\n Please enter the email address in email format \n";
			if (!validObj.emailValidation(email)) {
				System.out.println(prompt);
			}
		} while (!validObj.emailValidation(email));

		customerBean.setEmail(email);

		String telephoneNum;
		do {
			System.out.println("Phone Number:");
			telephoneNum = sc.next();
			prompt = "\nMobile No is not valid,\n"
					+ " please enter 10 digit number(Must Start with either 7 or 8 or 9).\n";
			if (!validObj.mobileNoValidation(telephoneNum)) {
				System.out.println(prompt);
			}
		} while (!validObj.mobileNoValidation(telephoneNum));

		customerBean.setTelephoneNum(Long.parseLong(telephoneNum));

		return customerBean;

	}//

}// end of class
