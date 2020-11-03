package com.capgemini.forestrymanagementsystembyusingjdbc.controller;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.capgemini.forestrymanagementsystembyusingjdbc.bean.LandBean;
import com.capgemini.forestrymanagementsystembyusingjdbc.exception.InvalidInputException;
import com.capgemini.forestrymanagementsystembyusingjdbc.exception.LandException;
import com.capgemini.forestrymanagementsystembyusingjdbc.factory.Factory;
import com.capgemini.forestrymanagementsystembyusingjdbc.service.LandService;

public class LandMain {
	LandService services = Factory.instanceOfLandServices();
	Validation validObj = new Validation();
	Scanner sc = new Scanner(System.in);
	Scanner scn = new Scanner(System.in);
	String prompt;
	LandBean landBean = new LandBean();

	public void landOperation() {
		try {
			System.out.println("LAND DETAILS");
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
					addLandDetails();
					break;
				case 2:
					updateLandDetails();
					break;
				case 3:
					viewLandDetails();
					break;
				case 4:
					deleteLandDetails();
					break;
				case 5:
					Admin admin = new Admin();
					admin.adminOPeration();
					return;
				default:
					System.out.println("Please Select The Options As per the Mentioned Number");
					break;
				}
			}
		} catch (NumberFormatException | InputMismatchException e) {
			throw new InvalidInputException("Please Select The Options As per the Mentioned Number");
		}
	}

	private void deleteLandDetails() {

		int lndid;
		String landid;
		do {
			System.out.print("Land Id:");
			landid = sc.next();
			prompt = "\nLand Id should conatin only numbers.\n";
			if (!validObj.idValidation(landid)) {
				System.out.println(prompt);
			}

		} while (!validObj.idValidation(landid));

		lndid = Integer.parseInt(landid);
		boolean flag = false;
		try {
			flag = services.deleteLandDetails(lndid);
			if (flag) {
				System.out.println("Land Deleted Sucessfuly");
			}
		} catch (LandException e) {
			System.err.println(e.getMessage());
		}

	}

	private void viewLandDetails() {
		System.out.println("Enter The Below Details To View Land Details");
		String landid;
		do {
			System.out.print("Land Id:");
			landid = sc.next();
			prompt = "\nLand Id should conatin only numbers.\n";
			if (!validObj.idValidation(landid)) {
				System.err.println(prompt);
			}

		} while (!validObj.idValidation(landid));

		int landId = Integer.parseInt(landid);
		try {
			landBean = services.viewLandDetails(landId);
			if (landBean != null) {
				System.out.println(landBean);
			} else {
				System.err.println("Land Details Not Found To View");
			}
		} catch (LandException e) {
			System.err.println(e.getMessage());
		}

	}

	private void updateLandDetails() {

		String landid;
		do {
			System.out.print("Land Id:");
			landid = sc.next();
			prompt = "\nLand Id should conatin only numbers.\n";
			if (!validObj.idValidation(landid)) {
				System.err.println(prompt);
			}

		} while (!validObj.idValidation(landid));

		String landvalue;
		do {
			System.out.println("Enter the landvalue");
			landvalue = sc.next();
			prompt = "\nLand Value should conatin only numbers.\n";
			if (!validObj.valueValidation(landvalue)) {
				System.err.println(prompt);
			}

		} while (!validObj.valueValidation(landvalue));

		int landId = Integer.parseInt(landid);
		long lanValue = Long.parseLong(landvalue);

		boolean updateFlag = false;
		try {
			updateFlag = services.updateLandDeatails(landId, lanValue);
			if (updateFlag) {
				System.out.println("Land Details Updated Successfully");
			}

		} catch (LandException e) {
			System.err.println(e.getMessage());
		}

	}

	private void addLandDetails() {

		System.out.println("Enter The Below Details To Add Land");

		LandBean landBean = getLandInfoInput();

		boolean addFlag = false;
		try {
			addFlag = services.addLandDetails(landBean);
			if (addFlag) {
				System.out.println("Land Details Added Successfully");
			}
		} catch (LandException e) {
			System.err.println(e.getMessage());
		}

	}

	@SuppressWarnings("static-access")
	public LandBean getLandInfoInput() {
		String landid;
		do {
			System.out.print("Land Id:");
			landid = sc.next();
			prompt = "\nLand Id should conatin only numbers.\n";
			if (!validObj.idValidation(landid)) {
				System.out.println(prompt);
			}

		} while (!validObj.idValidation(landid));

		String landlocation = null;
		do {
			System.out.println("Enter Land Location");
			if (scn.hasNextLine()) {
				landlocation = scn.nextLine();
			}
			prompt = "\nPlease Enter The Corret Location.\n";
			if (!validObj.addresValidation(landlocation)) {
				System.err.println(prompt);
			}

		} while (!validObj.addresValidation(landlocation));

		String landvalue;
		do {
			System.out.println("Enter the landvalue");
			landvalue = sc.next();
			prompt = "\nLand Value should conatin only numbers.\n";
			if (!validObj.valueValidation(landvalue)) {
				System.err.println(prompt);
			}

		} while (!validObj.valueValidation(landvalue));

		String relesedate;
		do {
			System.out.println("Enter the relese date");
			relesedate = sc.next();
			prompt = "\nPlease Enter The Date in the Correct Date Format :dd-MM-yyyy \n";
			if (!validObj.isValidDate(relesedate)) {
				System.out.println(prompt);
			}

		} while (!validObj.isValidDate(relesedate));

		landBean.setLandid(Integer.parseInt(landid));
		landBean.setLandLocation(landlocation);
		landBean.setLandValue(Long.parseLong(landvalue));
		landBean.setRealisedDate(relesedate);
		return landBean;
	}

}
