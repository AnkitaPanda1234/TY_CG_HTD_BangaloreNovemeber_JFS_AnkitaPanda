package com.capgemini.forestrymanagementsystembyusingjdbc.controller;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.capgemini.forestrymanagementsystembyusingjdbc.bean.ContractorBean;
import com.capgemini.forestrymanagementsystembyusingjdbc.bean.CustomerBean;
import com.capgemini.forestrymanagementsystembyusingjdbc.bean.HauilerBean;
import com.capgemini.forestrymanagementsystembyusingjdbc.bean.InventoryBean;
import com.capgemini.forestrymanagementsystembyusingjdbc.exception.ContractException;
import com.capgemini.forestrymanagementsystembyusingjdbc.exception.CustomerException;
import com.capgemini.forestrymanagementsystembyusingjdbc.exception.HauilerException;
import com.capgemini.forestrymanagementsystembyusingjdbc.exception.InvalidInputException;
import com.capgemini.forestrymanagementsystembyusingjdbc.exception.ProductException;
import com.capgemini.forestrymanagementsystembyusingjdbc.exception.SchedulerException;
import com.capgemini.forestrymanagementsystembyusingjdbc.service.ContractorServices;
import com.capgemini.forestrymanagementsystembyusingjdbc.service.ContractorServicesImpl;
import com.capgemini.forestrymanagementsystembyusingjdbc.service.CustomerServices;
import com.capgemini.forestrymanagementsystembyusingjdbc.service.CustomerServicesImpl;
import com.capgemini.forestrymanagementsystembyusingjdbc.service.HauilerService;
import com.capgemini.forestrymanagementsystembyusingjdbc.service.HauilerServiceImpl;
import com.capgemini.forestrymanagementsystembyusingjdbc.service.InventoryServices;
import com.capgemini.forestrymanagementsystembyusingjdbc.service.InventoryServicesImpl;
import com.capgemini.forestrymanagementsystembyusingjdbc.service.LandService;
import com.capgemini.forestrymanagementsystembyusingjdbc.service.LandServiceImpl;
import com.capgemini.forestrymanagementsystembyusingjdbc.service.ScheduleService;
import com.capgemini.forestrymanagementsystembyusingjdbc.service.ScheduleServiceImpl;

public class ContractorMain {

	CustomerServices customerServices = new CustomerServicesImpl();
	InventoryServices inventoryServices = new InventoryServicesImpl();
	ContractorServices contractorServices = new ContractorServicesImpl();
	LandService landService = new LandServiceImpl();
	ScheduleService scheduleServices = new ScheduleServiceImpl();
	HauilerService hauilerService = new HauilerServiceImpl();

	ContractorBean bean;
	Scanner sc = new Scanner(System.in);
	Scanner scn = new Scanner(System.in);
	String prompt;
	Validation validObj = new Validation();

	Schedule schedule = new Schedule();

	public void contractOperation() {
		try {
			System.out.println("Contract  Details");
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
					viewContract();
					break;
				case 3:
					deleteContract();
					break;
				case 4:
					Admin admin = new Admin();
					admin.adminOPeration();
					break;
				default:
					System.out.println("Please Select The Options As per the Mentioned Number");
					break;
				}

			}
		} catch (NumberFormatException | InputMismatchException e) {
			throw new InvalidInputException("Please Select The Options As per the Mentioned Number");
		}
	}

	private void viewContract() {

		String contractNo;
		do {
			System.out.print("Enter Contract No To View The Contract Details");
			contractNo = sc.next();
			prompt = "\nContract No should conatin only numbers.\n";
			if (!validObj.idValidation(contractNo)) {
				System.out.println(prompt);
			}

		} while (!validObj.idValidation(contractNo));

		int contractId = Integer.parseInt(contractNo);

		ContractorBean contractorBean = null;
		try {
			contractorBean = contractorServices.viewContract(contractId);
			if (contractorBean != null) {
				System.out.println(contractorBean);
			} else {
				System.out.println("Contract No Not Found To View");
			}
		} catch (ContractException e) {
			System.err.println(e.getMessage());
		}

	}

	private void deleteContract() {

		System.out.println("Enter The below details to Delete Contract");
		String contractNo;
		do {
			System.out.print("Contract No:");
			contractNo = sc.next();
			prompt = "\nContract No should conatin only numbers.\n";
			if (!validObj.idValidation(contractNo)) {
				System.out.println(prompt);
			}

		} while (!validObj.idValidation(contractNo));

		int contractId = Integer.parseInt(contractNo);

		boolean flag = false;
		try {

			ContractorBean contractorBean = contractorServices.viewContract(contractId);

			if (contractorBean == null) {
				throw new ContractException("Contract Details Not Present For The Given Contract Id");
			} else {
				if ("Cancelled".equalsIgnoreCase(contractorBean.getStatus())) {
					throw new ContractException("Contractor Id is already Deleted");
				} else {
					InventoryBean productBean = null;
					int productId = 0;
					if (contractorBean != null) {
						productBean = inventoryServices.searchProduct(contractorBean.getProductId());
						productId = contractorBean.getProductId();
					}

					long actualQuantity = productBean.getProductQuantity();
					long totalQuantity = contractorBean.getQunatity() + actualQuantity;

					flag = contractorServices.deleteContract(contractId, contractorBean.getorderId());

					if (flag) {
						System.out.println("Contract With ID " + contractId + "deleted Successfully for" + " Order Id: "
								+ contractorBean.getContractNo());
						/*inventoryServices.modifyProduct(productId, String.valueOf(totalQuantity),
								"updateQuanitityQuery");*/

						//scheduleServices.updateSchedule(contractId, "Cancelled");

					}
				}
			}

		} catch (ContractException | ProductException | SchedulerException e) {
			System.err.println(e.getMessage());
		}

	}

	private void addContract() {
		@SuppressWarnings("unused")
		boolean addFlag = false;
		System.out.println("Enter The Below Details To Add Contract : ");
		ContractorBean contractor = getContractDetails();
		contractor.setStatus("Ordered");
		try {

			int customerId = contractor.getCustomerId();
			int productId = contractor.getProductId();
			int haulierId = contractor.getHaulierId();
			long orderQunatity = contractor.getQunatity();

			long availableQuantity = 0;
			long finalQunatity = 0;

			// CHECK CUSTOMER IS PRESENT OR NOT

			CustomerBean customerBean = customerServices.viewCustomer(customerId);
			if (customerBean == null) {
				throw new CustomerException("Customer With Customer Id :" + customerId + " Not Present ");
			}

			// CHECK HAUILER IS PRESENT OR NOT

			HauilerBean hauilerBean = hauilerService.searchHauiler(haulierId);
			if (hauilerBean == null) {
				throw new HauilerException("Hauiler With Hauiler Id :" + haulierId + " Not Present ");
			}
			// CHEKC PRODUCT IS PRESNT OR NOT
			InventoryBean productBean = inventoryServices.searchProduct(productId);
			if (productBean == null) {
				throw new ProductException("Product With Product Id :" + productId + " Not Present ");
			} else {
				availableQuantity = productBean.getProductQuantity();
			}

			if (availableQuantity < orderQunatity) {
				throw new ContractException("Currently don't have the total product in our stock ");
			} /*else if (availableQuantity > orderQunatity) {
				finalQunatity = availableQuantity - orderQunatity;
			}*/
			boolean addContractFlag = contractorServices.addContract(contractor);

			if (addContractFlag) {
				System.out.println("Contract Details Added Successfully");
				//inventoryServices.modifyProduct(productId, String.valueOf(finalQunatity), "updateQuanitityQuery");
			}

		} catch (ContractException | CustomerException | HauilerException | ProductException e) {
			System.err.println(e.getMessage());

		}

	}

	@SuppressWarnings("static-access")
	private ContractorBean getContractDetails() {

		ContractorBean contractor = new ContractorBean();

		String orderNo;
		do {
			System.out.println("Order No:");
			orderNo = sc.next();
			prompt = "\nOrder No should conatin only numbers.\n";
			if (!validObj.idValidation(orderNo)) {
				System.out.println(prompt);
			}

		} while (!validObj.idValidation(orderNo));
		int ordNo = Integer.parseInt(orderNo);

		String contractNo;
		do {
			System.out.println("Contract No:");
			contractNo = sc.next();
			prompt = "\nContract No should conatin only numbers.\n";
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

		contractor.setorderId(ordNo);
		contractor.setContractNo(contNo);
		contractor.setCustomerId(customerid);
		contractor.setProductId(productid);
		contractor.setHaulierId(haulierid);
		contractor.setDeliveryDate(deliveryDate);
		contractor.setQunatity(Long.parseLong(qunatity));
		return contractor;
	}
}
