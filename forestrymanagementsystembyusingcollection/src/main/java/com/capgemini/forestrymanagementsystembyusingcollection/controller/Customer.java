package com.capgemini.forestrymanagementsystembyusingcollection.controller;

import java.util.Scanner;

import com.capgemini.forestrymanagementsystembyusingcollection.baen.ContractorBean;
import com.capgemini.forestrymanagementsystembyusingcollection.baen.CustomerBean;
import com.capgemini.forestrymanagementsystembyusingcollection.dao.ContractorDAO;
import com.capgemini.forestrymanagementsystembyusingcollection.dao.CustomerDAO;
import com.capgemini.forestrymanagementsystembyusingcollection.dao.ProductDAO;
import com.capgemini.forestrymanagementsystembyusingcollection.dao.SchedulerDAO;
import com.capgemini.forestrymanagementsystembyusingcollection.exception.ContractException;
import com.capgemini.forestrymanagementsystembyusingcollection.exception.CustomerException;
import com.capgemini.forestrymanagementsystembyusingcollection.exception.ProductException;
import com.capgemini.forestrymanagementsystembyusingcollection.factory.ForestDaoManager;


public class Customer {

	static CustomerDAO dao = ForestDaoManager.instanceofCustomerDAOImpl();
	static SchedulerDAO schedulerDAO = ForestDaoManager.instanceofSchedulerDAOImpl();
	static ProductDAO productDAO = ForestDaoManager.instanceofProductDAOImpl();
	static ContractorDAO contractorDAO = ForestDaoManager.instanceofContractorDAOImpl();
	CustomerBean customerBean = new CustomerBean();
	Scanner sc = new Scanner(System.in);
	Scanner scn = new Scanner(System.in);
	Validation validObj = new Validation();
	String prompt;
	boolean loginFlag = false;

	public void customer() {

		System.out.println("Customer Details Page");
		while (true) {

			System.out.println("1:Add Customer");
			System.out.println("2:Edit Customer");
			System.out.println("3:Serach Customer");
			System.out.println("4:Delete Customer");
			System.out.println("5:Product Details");
			System.out.println("6:Order Details");
			System.out.println("7:Return");

			try {
				int choice = sc.nextInt();
				switch (choice) {
				case 1:
					addCustomer();
					break;
				case 2:
					updateCustomer();
					break;
				case 3:
					searchCustomer();
					break;
				case 4:
					deleteCustomer();
					break;
				case 5:
					try {
						productDAO.getAllProducts();
					} catch (ProductException e) {
						System.out.println(e.getMessage());
					}
					break;
				case 6:
					String orderId;
					do {
						System.out.println("Enter Contract No To Search Order:");
						orderId = sc.next();
						prompt = "\nContract No should conatin only numbers.\n";
						if (!validObj.idValidation(orderId)) {
							System.out.println(prompt);
						}
					} while (!validObj.idValidation(orderId));

					ContractorBean contractorBean = null;
					try {
						contractorBean = contractorDAO.searchContract(Integer.parseInt(orderId));
						if (contractorBean != null) {
							System.out.println("Your Order Details Are As Below:");
							System.out.println(contractorBean);

						} else {
							System.err.println("Currently You don't have any order with the given Ordr Id");
						}

					} catch (ContractException e) {
						System.err.println(e.getMessage());
					}

					break;

				case 7:
					TestMain.main();
					break;
				default:
					System.err.println("Please Select The Options As per the Mentioned Number");
					break;
				}
			} // TRY
			catch (Exception e) {
				try {
					e.printStackTrace();
					throw new CustomerException("Please Select The Above Options As per the Mentioned Number");
				} catch (CustomerException e1) {
					e1.printStackTrace();
				}
			} // CATCH

		} // while

	} // End Of If

	// }

	private void deleteCustomer() {
		String cstid;
		int customerid;
		do {
			System.out.println("Enter the Customer ID you want to delete");
			cstid = sc.next();
			prompt = "\nCustomer Id should conatin only numbers.\n";
			if (!validObj.idValidation(cstid)) {
				System.err.println(prompt);
			}

		} while (!validObj.idValidation(cstid));
		customerid = Integer.parseInt(cstid);

		boolean deleteFlag = false;
		try {
			deleteFlag = dao.deleteCustomer(customerid);
			if (deleteFlag) {
				System.out.println("Customer Details Deleted Successfully");
			} else {
				System.out.println("Customer Id Not Found To Delete");
			}
		} catch (CustomerException e) {
			System.out.println(e.getMessage());
		}

	}

	private void searchCustomer() {
		int cstSerchid;
		String cstSrchId;
		CustomerBean cstBean = null;
		do {
			System.out.println("Enter the Customer ID To View The Customer Details");
			cstSrchId = sc.next();
			prompt = "\nCustomer Id should conatin only numbers.\n";
			if (!validObj.idValidation(cstSrchId)) {
				System.out.println(prompt);
			}

		} while (!validObj.idValidation(cstSrchId));

		cstSerchid = Integer.parseInt(cstSrchId);
		try {
			cstBean = dao.searchCustomer(cstSerchid);
			if (cstBean != null) {
				System.out.println(cstBean);
			} else {
				System.out.println("Customer Id: " + cstSerchid + " Not Found To View");
			}
		} catch (CustomerException e) {
			System.out.println(e.getMessage());

		}

	}

	public void updateCustomer() {

		System.out.println("Enter The Below Details To Update Customer");

		boolean updateFlag = false;
		try {
			CustomerBean cstBean = getCustomerInfoInput();
			int cstId = cstBean.getCustomerid();
			updateFlag = dao.modifyCustomer(cstId, cstBean);
			if (updateFlag) {
				System.out.println("Customer Details Modified Successfully");
			}
		} catch (CustomerException e2) {
			System.out.println(e2.getMessage());

		}

	}

	public void addCustomer() {

		System.out.println("Enter The Below Details To Add Customer");

		boolean addFlag = false;
		try {
			CustomerBean cstBean = getCustomerInfoInput();
			int cstId = cstBean.getCustomerid();
			addFlag = dao.addCustomer(cstBean, cstId);
			if (addFlag) {
				System.out.println("Customer Details Added Successfully");
			}
		} catch (CustomerException e) {
			System.out.println(e.getMessage());

		}
	}

	public CustomerBean getCustomerInfoInput() {
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
			prompt = "\n Customer name should contain only letters.\n";
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
			prompt = "\nPlease enter a valid address for address2.\n";
			if (!validObj.addresValidation(address2)) {
				System.out.println(prompt);
			}
		} while (!validObj.addresValidation(address2));

		customerBean.setStreetAddress2(address2);

		String town = null;
		do {
			System.out.println("Town:");
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
			System.out.println("Email ID : ");
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

	}

}
