package com.capgemini.forestrymanagementsystembyusingjdbc.controller;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.capgemini.forestrymanagementsystembyusingjdbc.bean.ContractorBean;
import com.capgemini.forestrymanagementsystembyusingjdbc.bean.InventoryBean;
import com.capgemini.forestrymanagementsystembyusingjdbc.bean.ScheduleBean;
import com.capgemini.forestrymanagementsystembyusingjdbc.exception.ContractException;
import com.capgemini.forestrymanagementsystembyusingjdbc.exception.InvalidInputException;
import com.capgemini.forestrymanagementsystembyusingjdbc.exception.LandException;
import com.capgemini.forestrymanagementsystembyusingjdbc.exception.ProductException;
import com.capgemini.forestrymanagementsystembyusingjdbc.exception.SchedulerException;
import com.capgemini.forestrymanagementsystembyusingjdbc.factory.Factory;
import com.capgemini.forestrymanagementsystembyusingjdbc.service.ContractorServices;
import com.capgemini.forestrymanagementsystembyusingjdbc.service.InventoryServices;
import com.capgemini.forestrymanagementsystembyusingjdbc.service.InventoryServicesImpl;
import com.capgemini.forestrymanagementsystembyusingjdbc.service.ScheduleService;

public class Schedule {

	ScheduleService scheduleService = Factory.instanceOfScheduleService();
	ContractorServices contractorServices = Factory.instanceOfContractorServices();
	InventoryServices inventoryServices = new InventoryServicesImpl();
	Scanner sc = new Scanner(System.in);
	Scanner scn = new Scanner(System.in);
	Validation validObj = new Validation();
	String prompt;
	ScheduleBean scheduler = new ScheduleBean();

	public void scheduleOperation() {
		try {
			System.out.println("Schedule Operations");
			while (true) {
				System.out.println("Please Select The Operation:");
				System.out.println("1:Add");
				System.out.println("2:Search");
				System.out.println("3:Cancel");
				System.out.println("4:Return");

				int choice = sc.nextInt();
				switch (choice) {
				case 1:
					addSchedule();
					break;
				case 2:
					searchSchedule();
					break;
				case 3:
					cancelSchedule();
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

	private void cancelSchedule() {
		System.out.println("Enter The Schedule No To Cancel");
		String scheduleNo;
		do {
			System.out.println("Schedule No:");
			scheduleNo = sc.next();
			prompt = "\nSchedule No should conatin only numbers.\n";
			if (!validObj.idValidation(scheduleNo)) {
				System.out.println(prompt);
			}

		} while (!validObj.idValidation(scheduleNo));
		int schduleNo = Integer.parseInt(scheduleNo);

		boolean celcelFlag = false;
		ScheduleBean scheduleBean = null;
		long orderQunatity = 0;

		long availableQuantity = 0;
		long finalQunatity = 0;
		try {
			scheduleBean = scheduleService.searchSchedule(schduleNo);
			celcelFlag = scheduleService.cancelSchedule(schduleNo);
			if (celcelFlag) {
				System.out.println("Scheduled Cancelled Sucessfuly");

				int productId = scheduleBean.getProductId();
				orderQunatity = scheduleBean.getQunatity();
				// CHEKC PRODUCT IS PRESNT OR NOT
				InventoryBean productBean = inventoryServices.searchProduct(productId);
				if (productBean == null) {
					throw new ProductException("Product With Product Id :" + productId + " Not Present ");
				} else {
					availableQuantity = productBean.getProductQuantity();
				}

				if (availableQuantity < orderQunatity) {
					throw new ContractException(
							"Currently don't have the total product in our stock \n Contact Admin To Add Product In Stock ");
				} else if (availableQuantity > orderQunatity) {
					finalQunatity = availableQuantity + orderQunatity;
				}

				inventoryServices.modifyProduct(productId, String.valueOf(finalQunatity), "updateQuanitityQuery");

			}
		} catch (SchedulerException | ProductException e) {
			System.out.println(e.getMessage());
		}

	}

	private void searchSchedule() {
		System.out.println("Enter The Schedule No To Delete");
		String scheduleNo;
		do {
			System.out.println("Schedule No:");
			scheduleNo = sc.next();
			prompt = "\nSchedule No should conatin only numbers.\n";
			if (!validObj.idValidation(scheduleNo)) {
				System.out.println(prompt);
			}

		} while (!validObj.idValidation(scheduleNo));
		int schduleNo = Integer.parseInt(scheduleNo);

		ScheduleBean scheduleBean = null;

		try {
			scheduleBean = scheduleService.searchSchedule(schduleNo);
			if (scheduleBean != null) {
				System.out.println(scheduleBean);
			} else {
				System.out.println("Schedule Details Not Found To View");
			}
		} catch (SchedulerException e) {
			System.out.println(e.getMessage());
		}

	}

	private void addSchedule() {
		ScheduleBean scheduleBean = getScheduleDetails();
		boolean addSchdlFlag = false;
		try {
			ContractorBean contractorBean = contractorServices.viewContract(scheduleBean.getContractId());

			long orderQunatity = 0;

			long availableQuantity = 0;
			long finalQunatity = 0;
			int productId = 0;

			if (contractorBean != null && contractorBean.getStatus().equalsIgnoreCase("Ordered")) {
				orderQunatity = contractorBean.getQunatity();
				productId = contractorBean.getProductId();
				// CHEKC PRODUCT IS PRESNT OR NOT
				InventoryBean productBean = inventoryServices.searchProduct(productId);
				if (productBean == null) {
					throw new ProductException("Product With Product Id :" + productId + " Not Present ");
				} else {
					availableQuantity = productBean.getProductQuantity();
				}

				if (availableQuantity < orderQunatity) {
					throw new ContractException(
							"Currently don't have the total product in our stock \n Contact Admin To Add Product In Stock ");
				} else if (availableQuantity > orderQunatity) {
					finalQunatity = availableQuantity - orderQunatity;
				}

				scheduleBean.setCustomerId(contractorBean.getCustomerId());
				scheduleBean.setOrderId(contractorBean.getorderId());
				scheduleBean.setProductId(contractorBean.getProductId());
				scheduleBean.setDeliveryDate(contractorBean.getDeliveryDate());
				scheduleBean.setQunatity(orderQunatity);
				scheduleBean.setStatus("Scheduled");
				addSchdlFlag = scheduleService.addSchedule(scheduleBean);
			} else {
				System.out.println(
						"Currently There Is No Order Placed For The Given Contractor. Please add Order for the Given Contractor");
			}

			if (addSchdlFlag) {
				System.out
						.println("Scheduler Details Added Successfully For Date: " + contractorBean.getDeliveryDate());
				inventoryServices.modifyProduct(productId, String.valueOf(finalQunatity), "updateQuanitityQuery");
			}
		} catch (SchedulerException | ContractException | ProductException e) {
			System.err.println(e.getMessage());
		}
	}

	@SuppressWarnings("static-access")
	private ScheduleBean getScheduleDetails() {

		System.out.println("Enter The Below Details To Add Schedule");

		ScheduleBean scheduleBean = new ScheduleBean();

		String scheduleNo;
		do {
			System.out.println("Schedule No:");
			scheduleNo = sc.next();
			prompt = "\nSchedule No should conatin only numbers.\n";
			if (!validObj.idValidation(scheduleNo)) {
				System.out.println(prompt);
			}

		} while (!validObj.idValidation(scheduleNo));
		int schduleNo = Integer.parseInt(scheduleNo);

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

		scheduleBean.setScheduleId(schduleNo);
		scheduleBean.setContractId(contNo);

		return scheduleBean;
	}

}
