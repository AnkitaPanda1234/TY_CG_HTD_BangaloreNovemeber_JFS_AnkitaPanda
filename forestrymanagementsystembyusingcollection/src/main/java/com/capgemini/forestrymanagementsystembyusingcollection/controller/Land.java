package com.capgemini.forestrymanagementsystembyusingcollection.controller;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.capgemini.forestrymanagementsystembyusingcollection.baen.LandBean;
import com.capgemini.forestrymanagementsystembyusingcollection.dao.LandDAO;
import com.capgemini.forestrymanagementsystembyusingcollection.exception.InvalidInputException;
import com.capgemini.forestrymanagementsystembyusingcollection.exception.LandException;
import com.capgemini.forestrymanagementsystembyusingcollection.factory.ForestDaoManager;
public class Land {
	static LandDAO dao = ForestDaoManager.instanceofLandDAOImpl();
	Validation validObj = new Validation();

	Scanner sc = new Scanner(System.in);
	Scanner scn = new Scanner(System.in);
	String prompt;
	LandBean landBean = new LandBean();

	public void landMain() {
		try {
			System.out.println("Welcome To Land Page");
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
					addLand();
					break;
				case 2:
					updateLand();
					break;
				case 3:
					searchLand();
					break;
				case 4:
					deleteLand();
					break;
				case 5:
					Admin adminMain = new Admin();
					adminMain.adminMain();
					return;
				default:
					System.err.println("Please Select The Options As per the Mentioned Number");
					break;
				}
			}
		} catch (NumberFormatException | InputMismatchException | InvalidInputException e) {
			throw new InvalidInputException("Please Select The Options As per the Mentioned Number");
		}
	}

	private void deleteLand() {

		boolean deletFlag = false;
		System.out.println("Enter The Below Details To Delete Land");
		String landid;
		do {
			System.out.print("Land Id:");
			landid = sc.next();
			prompt = "\nLand Id should conatin only numbers.\n";
			if (!validObj.idValidation(landid)) {
				System.err.println(prompt);
			}

		} while (!validObj.idValidation(landid));

		try {
			deletFlag = dao.deleteLand(Integer.parseInt(landid));
			if (deletFlag) {
				System.out.println("Land Details Deleted");
			}
		} catch (LandException e) {
			System.err.println(e.getMessage());
		}
	}

	private void searchLand() {
		LandBean landBean = null;
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

		try {
			landBean = dao.getLand(Integer.parseInt(landid));
			if (landBean != null) {
				System.out.println(landBean);
			} else {
				System.err.println("Land ID: " + landid + " Not Found To View");
			}
		} catch (LandException e) {
			System.err.println(e.getMessage());
		}
	}

	private void updateLand() {

		boolean updateFlag = false;
		System.out.println("Enter The Below Details To Update Land");
		LandBean lndBean = getLandInfoInput();
		int landId = lndBean.getLandid();
		try {
			updateFlag = dao.updateLand(landId, lndBean);
			if (updateFlag) {
				System.out.println("Land Details Updated Successfully");
			}

		} catch (LandException e) {
			System.err.println(e.getMessage());
		}
	}

	private void addLand() {

		System.out.println("Enter The Below Details To Add Land");
		LandBean lndBean = getLandInfoInput();
		int landId = lndBean.getLandid();

		boolean addFlag = false;
		try {
			addFlag = dao.addDetails(lndBean, landId);
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
				System.err.println(prompt);
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
				System.err.println(prompt);
			}

		} while (!validObj.isValidDate(relesedate));

		landBean.setLandid(Integer.parseInt(landid));
		landBean.setLandlocation(landlocation);
		landBean.setLandvalue(Long.parseLong(landvalue));
		landBean.setRelesedate(relesedate);
		return landBean;
	}

	public String getLandIDInput(String param) {

		String landid;
		String cstInput = null;
		if ("view".equalsIgnoreCase(param)) {
			cstInput = "Enter Land Id To Search ";
		} else if ("delete".equalsIgnoreCase(param)) {
			cstInput = "Enter Land Id To Delete ";
		}

		do {
			System.out.print(cstInput);
			landid = sc.next();
			prompt = "\nLand Id should conatin only numbers.\n";
			if (!validObj.idValidation(landid)) {
				System.err.println(prompt);
			}

		} while (!validObj.idValidation(landid));

		return landid;
	}
}
