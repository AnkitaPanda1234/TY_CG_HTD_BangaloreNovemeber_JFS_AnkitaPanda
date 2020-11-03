package com.capgemini.forestrymanagementsystembyusingcollection.controller;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.capgemini.forestrymanagementsystembyusingcollection.baen.HauilerBean;
import com.capgemini.forestrymanagementsystembyusingcollection.dao.HauilerDAO;
import com.capgemini.forestrymanagementsystembyusingcollection.exception.HauilerException;
import com.capgemini.forestrymanagementsystembyusingcollection.exception.InvalidInputException;
import com.capgemini.forestrymanagementsystembyusingcollection.factory.ForestDaoManager;
public class Hauiler {
	static HauilerDAO dao = ForestDaoManager.instanceofHauilerDAOImpl();
	HauilerBean hauilerBean = new HauilerBean();
	Scanner sc = new Scanner(System.in);
	Validation validObj = new Validation();
	Scanner scn = new Scanner(System.in);
	String prompt;

	public void hauiler() {
		try {
			System.out.println("Welcoom to Hauiler Page");
			while (true) {
				System.out.println("Please Select The Operation As Per Your Choice:");
				System.out.println("1:Add");
				System.out.println("2:Modify");
				System.out.println("3:Search");
				System.out.println("4:Delete");
				System.out.println("5:Return");

				int choice = sc.nextInt();
				switch (choice) {

				case 1:
					addHauiler();
					break;
				case 2:
					updateHaulier();
					break;
				case 3:
					searchHaulier();
					break;
				case 4:
					deleteHauiler();
					break;
				case 5:
					TestMain.main();
					return;
				default:
					System.out.println("Please Select The Options As per the Mentioned Number");
					break;
				}
			}
		} catch (NumberFormatException | InputMismatchException | InvalidInputException e) {
			throw new InvalidInputException("Please Select The Options As per the Mentioned Number");
		}
	}

	private void updateHaulier() {

		boolean addFlag = false;
		HauilerBean hauilerBean = null;
		System.out.println("Enter The Below Details To Update Hauiler");
		try {
			hauilerBean = getHauilerInfoInput();
			addFlag = dao.modifyHauiler(hauilerBean.getHauilerid(), hauilerBean);
			if (addFlag) {
				System.out.println("Hauiler Details Updated Successfully");
			}
		} catch (HauilerException e) {
			System.out.println(e.getMessage());
		}

	}

	private void searchHaulier() {
		String hauilerId;
		HauilerBean hauilerBean = null;
		do {
			System.out.print("Enter Hauiler Id To View Hauiler Details:");
			hauilerId = sc.next();
			prompt = "\nHauiler Id should conatin only numbers.\n";
			if (!validObj.idValidation(hauilerId)) {
				System.out.println(prompt);
			}

		} while (!validObj.idValidation(hauilerId));

		try {
			hauilerBean = dao.searchHauiler(Integer.parseInt(hauilerId));
			if (hauilerBean != null) {
				System.out.println(hauilerBean);
			} else {
				System.out.println("Hauiler Id: " + hauilerId + " Not Found To Seacrch");
			}
		} catch (HauilerException e) {
			System.out.println(e.getMessage());
		}

	}

	private void deleteHauiler() {
		boolean deletFlag = false;
		String hauilerId;
		do {
			System.out.print("Enter Hauiler Id To Delete:");
			hauilerId = sc.next();
			prompt = "\nHauiler Id should conatin only numbers.\n";
			if (!validObj.idValidation(hauilerId)) {
				System.out.println(prompt);
			}

		} while (!validObj.idValidation(hauilerId));

		try {
			deletFlag = dao.deleteHauiler(Integer.parseInt(hauilerId));
			if (deletFlag) {
				System.out.println("Hauiler Details Deleted");
			} else {
				System.out.println("Hauiler Id Not Found To Delete");
			}
		} catch (HauilerException e) {
			System.out.println(e.getMessage());
		}
	}

	private void addHauiler() {

		boolean addFlag = false;
		HauilerBean hauilerBean = null;
		System.out.println("Enter The Below Details To Add Hauiler");
		try {
			hauilerBean = getHauilerInfoInput();
			addFlag = dao.addHauiler(hauilerBean, hauilerBean.getHauilerid());
			if (addFlag) {
				System.out.println("Hauiler Details Added Successfully");
			}
		} catch (HauilerException e) {
			System.out.println(e.getMessage());
		}

	}

	public HauilerBean getHauilerInfoInput() {

		HauilerBean hauilerBean = new HauilerBean();

		String hauilerid;

		do {
			System.out.print("Hauiler Id:");
			hauilerid = sc.next();
			prompt = "\nHauiler Id should conatin only numbers.\n";
			if (!validObj.idValidation(hauilerid)) {
				System.out.println(prompt);
			}
		} while (!validObj.idValidation(hauilerid));

		String hauilername = null;

		do {
			System.out.print("Hauiler Name:");
			if (scn.hasNextLine()) {
				hauilername = scn.nextLine();
			}
			prompt = "\nHauiler name should contain only letters.\n";
			if (!validObj.nameValidation(hauilername)) {
				System.out.println(prompt);
			}

		} while (!validObj.nameValidation(hauilername));

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

		String address2 = null;
		do {
			System.out.println("Address2 :");
			if (scn.hasNextLine()) {
				address2 = scn.nextLine();
			}
			prompt = "\nPlease enter a valid address for address2.\n";
			if (!validObj.addresValidation(address2)) {
				System.out.println(prompt);
			}
		} while (!validObj.addresValidation(address2));

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

		int postalcode;
		do {
			System.out.println("Postal Code:");
			postalcode = sc.nextInt();
			prompt = "\n Postal code must contain 6 digit numbers.\n";
			if (!validObj.postalCodeValidation(postalcode)) {
				System.out.println(prompt);
			}
		} while (!validObj.postalCodeValidation(postalcode));

		String email;
		do {
			System.out.println("Email ID:");
			email = sc.next();
			prompt = "\n Please enter the email address in email format \n";
			if (!validObj.emailValidation(email)) {
				System.out.println(prompt);
			}
		} while (!validObj.emailValidation(email));

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

		hauilerBean.setHauilerid(Integer.parseInt(hauilerid));
		hauilerBean.setHauilername(hauilername);
		hauilerBean.setEmail(email);
		hauilerBean.setContactnum(Long.parseLong(telephoneNum));
		hauilerBean.setStreetAddress1(address1);
		hauilerBean.setStreetAddress2(address2);
		hauilerBean.setTown(town);
		hauilerBean.setPostalCode(postalcode);

		return hauilerBean;

	}
}
