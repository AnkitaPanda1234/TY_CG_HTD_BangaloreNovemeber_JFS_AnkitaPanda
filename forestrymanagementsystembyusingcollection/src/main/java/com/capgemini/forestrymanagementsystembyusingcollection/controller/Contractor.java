package com.capgemini.forestrymanagementsystembyusingcollection.controller;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.capgemini.forestrymanagementsystembyusingcollection.baen.ContractorBean;
import com.capgemini.forestrymanagementsystembyusingcollection.baen.CustomerBean;
import com.capgemini.forestrymanagementsystembyusingcollection.baen.HauilerBean;
import com.capgemini.forestrymanagementsystembyusingcollection.baen.ProductBean;
import com.capgemini.forestrymanagementsystembyusingcollection.dao.ContractorDAO;
import com.capgemini.forestrymanagementsystembyusingcollection.dao.CustomerDAO;
import com.capgemini.forestrymanagementsystembyusingcollection.dao.HauilerDAO;
import com.capgemini.forestrymanagementsystembyusingcollection.dao.LandDAO;
import com.capgemini.forestrymanagementsystembyusingcollection.dao.ProductDAO;
import com.capgemini.forestrymanagementsystembyusingcollection.dao.SchedulerDAO;
import com.capgemini.forestrymanagementsystembyusingcollection.exception.ContractException;
import com.capgemini.forestrymanagementsystembyusingcollection.exception.InvalidInputException;
import com.capgemini.forestrymanagementsystembyusingcollection.factory.ForestDaoManager;

public class Contractor {
	static ContractorDAO dao = ForestDaoManager.instanceofContractorDAOImpl();
	static CustomerDAO customerDAO = ForestDaoManager.instanceofCustomerDAOImpl();
	static SchedulerDAO schedulerDAO = ForestDaoManager.instanceofSchedulerDAOImpl();
	static ProductDAO productDAO = ForestDaoManager.instanceofProductDAOImpl();
	static LandDAO landDAO = ForestDaoManager.instanceofLandDAOImpl();
	static HauilerDAO hauilerDAO = ForestDaoManager.instanceofHauilerDAOImpl();

	Validation validObj = new Validation();
	String prompt;
	Scanner sc = new Scanner(System.in);
	Scanner scn = new Scanner(System.in);
	ContractorBean contractor = new ContractorBean();

	public void contractor() {
		try {
			System.out.println("Contract Details");
			while (true) {
				System.out.println("Please Select The Operation:");
				System.out.println("1:Add");
				System.out.println("2:Search");
				System.out.println("3:Delete");
				System.out.println("4:Return");

				int choice = sc.nextInt();
				switch (choice) {
				case 1:
					addContract();
					break;
				case 2:
					searchContract();
					break;
				case 3:
					deleteContract();
					break;
				case 4:
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

	private void deleteContract() {

		boolean deletFlag = false;
		String contractNo;
		do {
			System.out.print("Enter Contract No To Delete The Contract Details");
			contractNo = sc.next();
			prompt = "\nContract No should conatin only numbers.\n";
			if (!validObj.idValidation(contractNo)) {
				System.out.println(prompt);
			}

		} while (!validObj.idValidation(contractNo));

		try {
			deletFlag = dao.deleteContarctor(Integer.parseInt(contractNo));
			if (deletFlag) {
				System.out.println("Contract Details Deleted");
			}
		} catch (ContractException e) {
			System.err.println(e.getMessage());
		}

	}

	private void searchContract() {

		ContractorBean contractor = null;
		String contractNo;
		do {
			System.out.print("Enter Contract No To View The Contract Details");
			contractNo = sc.next();
			prompt = "\nContract No should conatin only numbers.\n";
			if (!validObj.idValidation(contractNo)) {
				System.out.println(prompt);
			}

		} while (!validObj.idValidation(contractNo));

		try {
			contractor = dao.searchContract(Integer.parseInt(contractNo));
			if (contractor != null) {
				System.out.println(contractor);
			} else {
				System.out.println("Contract No Not Found To View");
			}
		} catch (ContractException e) {
			System.out.println(e.getMessage());
		}
	}


	private void addContract() {

		boolean addFlag = false;
		System.out.println("Enter The Below Details To Add Contract");
		ContractorBean contractor = getContractDetails();

		try {

			@SuppressWarnings("unused")
			String productQuantity;
			long prodQuantity = 0;
			long finalQunatity = 0;

			int customerId = contractor.getCustomerId();
			int productId = contractor.getProductId();
			int haulierId = contractor.getHaulierId();
			long orderQunatity = contractor.getQunatity();

			// CHECK CUSTOMER IS PRESENT OR NOT
			CustomerBean cstBean = customerDAO.searchCustomer(customerId);
			if (cstBean == null) {
				throw new ContractException("Custer Details Not Present for the Customer Id :" + customerId);
			}
			// CHECK HAUILER IS PRESENT OR NOT
			HauilerBean hauilerBean = hauilerDAO.searchHauiler(haulierId);
			if (hauilerBean == null) {
				throw new ContractException("Hauiler Details Not Present for the given Hauiler Id:" + haulierId);
			}

			// CHEKC PRODUCT IS PRESNT OR NOT

			ProductBean productBean = productDAO.searchProduct(productId);
			if (productBean == null) {
				throw new ContractException("Product Details Not Present for the given Product Id:" + productId);
			}
			// CHECK THE AVAILABLE QUANITY OF THAT PRODUCT
			else {
				prodQuantity = productBean.getProductQuantity();
			}
			if (prodQuantity < orderQunatity) {
				throw new ContractException("Currently don't have the total product in our stock ");
			} else if (prodQuantity > orderQunatity) {
				finalQunatity = prodQuantity - orderQunatity;
			}
			contractor.setStatus("Ordered");
			addFlag = dao.addContarctor(contractor, contractor.getContractNo());
		
			if (addFlag) {
				System.out.println("Contract Details Added Successfully");
				// UPDATE THE PRODUCT QUANTITY ALSO:
				productBean.setProductQuantity(finalQunatity);
				productDAO.modifyproduct(productId, productBean);
			}
		} catch (ContractException e) {
			System.out.println(e.getMessage());
		}

	}

	@SuppressWarnings("static-access")
	private ContractorBean getContractDetails() {

		ContractorBean contractor = new ContractorBean();

		String orderNo;
		do {
			System.out.println("Order No:");
			orderNo = sc.next();
			prompt = "\nOrder no should conatin only numbers.\n";
			if (!validObj.idValidation(orderNo)) {
				System.out.println(prompt);
			}

		} while (!validObj.idValidation(orderNo));
		int ordNo = Integer.parseInt(orderNo);

		String contractNo;
		do {
			System.out.println("Contract No:");
			contractNo = sc.next();
			prompt = "\nContract no should conatin only numbers.\n";
			if (!validObj.idValidation(contractNo)) {
				System.out.println(prompt);
			}

		} while (!validObj.idValidation(contractNo));
		int contNo = Integer.parseInt(contractNo);

		int customerid;
		String custrid;
		do {
			System.out.print("Customer Id:");
			custrid = sc.next();
			prompt = "\nCustomer Id should conatin only numbers.\n";
			if (!validObj.idValidation(custrid)) {
				System.out.println(prompt);
			}

		} while (!validObj.idValidation(custrid));
		customerid = Integer.parseInt(custrid);

		int productid = 0;
		String prdid;
		do {
			System.out.print("Product Id:");
			prdid = sc.next();
			prompt = "\nProduct Id should conatin only numbers.\n";
			if (!validObj.idValidation(prdid)) {
				System.out.println(prompt);
			}

		} while (!validObj.idValidation(prdid));
		productid = Integer.parseInt(prdid);

		int haulierid = 0;
		String hldId;
		do {
			System.out.print("Hauiler Id:");
			hldId = sc.next();
			prompt = "\nHauiler Id should conatin only numbers.\n";
			if (!validObj.idValidation(hldId)) {
				System.out.println(prompt);
			}

		} while (!validObj.idValidation(hldId));
		haulierid = Integer.parseInt(hldId);

		String deliveryDate;
		do {
			System.out.print("Delivery Date:");
			deliveryDate = sc.next();
			prompt = "\nPlease Enter The Date in the Correct Date Format :dd-MM-yyyy \n";
			if (!validObj.isValidDate(deliveryDate)) {
				System.out.println(prompt);
			}

		} while (!validObj.isValidDate(deliveryDate));

		String qunatity;
		do {
			System.out.println("Product Qunatity : ");
			qunatity = sc.next();
			 prompt = "\nQuantity should conatin only numbers.\n";
			if (!validObj.valueValidation(qunatity)) {
				System.out.println(prompt);
			}

		} while (!validObj.valueValidation(qunatity));

		contractor.setOrderId(ordNo);
		contractor.setContractNo(contNo);
		contractor.setCustomerId(customerid);
		contractor.setProductId(productid);
		contractor.setHaulierId(haulierid);
		contractor.setDeliveryDate(deliveryDate);

		contractor.setQunatity(Long.parseLong(qunatity));
		return contractor;
	}

}
