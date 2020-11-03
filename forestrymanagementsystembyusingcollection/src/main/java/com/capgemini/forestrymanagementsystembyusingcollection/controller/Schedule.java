package com.capgemini.forestrymanagementsystembyusingcollection.controller;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.capgemini.forestrymanagementsystembyusingcollection.baen.ContractorBean;
import com.capgemini.forestrymanagementsystembyusingcollection.baen.ScheduleBean;
import com.capgemini.forestrymanagementsystembyusingcollection.dao.ContractorDAO;
import com.capgemini.forestrymanagementsystembyusingcollection.dao.CustomerDAO;
import com.capgemini.forestrymanagementsystembyusingcollection.dao.ProductDAO;
import com.capgemini.forestrymanagementsystembyusingcollection.dao.ScheduleDAO;
import com.capgemini.forestrymanagementsystembyusingcollection.exception.CustomerException;
import com.capgemini.forestrymanagementsystembyusingcollection.exception.InvalidInputException;
import com.capgemini.forestrymanagementsystembyusingcollection.exception.SchedulerException;
import com.capgemini.forestrymanagementsystembyusingcollection.factory.ForestDaoManager;
public class Schedule {
	static ScheduleDAO scheduledao = ForestDaoManager.instanceofScheduleDAOImpl();
	static ContractorDAO contractDao = ForestDaoManager.instanceofContractorDAOImpl();
	static CustomerDAO customerDAO = ForestDaoManager.instanceofCustomerDAOImpl();
	static ProductDAO productDAO = ForestDaoManager.instanceofProductDAOImpl();

	Scanner sc = new Scanner(System.in);
	Validation validObj = new Validation();
	String prompt;
	ScheduleBean schedulebean = new ScheduleBean();

	public void ScheduleOperation() {
		try {
			System.out.println("welcome to Schedule Page");
			while (true) {
				System.out.println("Please Select The Operation:");
				System.out.println("1:Add");
				System.out.println("2:Search");
				System.out.println("3.Return");
				int choice = sc.nextInt();
				switch (choice) {
				case 1:
					addSchedule();
					break;
				case 2:
					searchSchedule();
					break;
				case 3:
					TestMain.main();
					break;
				default:
					System.out.println("Please Select The Options As per the Mentioned Number");
					break;

				}
			}
		} catch (NumberFormatException | InputMismatchException | InvalidInputException e) {
			throw new InvalidInputException("Please Select The Options As per the Mentioned Number");
		}
	}

	private void searchSchedule() {
		int scheduleSerchid;
		String schedulSrchId;
		ScheduleBean scheduleBean = null;
		do {
			System.out.println("Enter the Schedule ID To View The Schedule Details");
			schedulSrchId = sc.next();
			prompt = "\n Schedule Id should conatin only numbers.\n";
			if (!validObj.idValidation(schedulSrchId)) {
				System.out.println(prompt);
			}

		} while (!validObj.idValidation(schedulSrchId));

		scheduleSerchid = Integer.parseInt(schedulSrchId);
		try {
			scheduleBean = scheduledao.searchSchedule(scheduleSerchid);
			if (scheduleBean != null) {
				System.out.println(scheduleBean);
			} else {
				System.out.println("Schedule Id: " + scheduleSerchid + " Not Found To View");
			}
		} catch (CustomerException e) {
			System.out.println(e.getMessage());

		}

	}

	private void addSchedule() {
		System.out.println("Enter The Below Details To Add Schedule");

		String scheduleNo;
		do {
			System.out.println("Schedule No:");
			scheduleNo = sc.next();
			prompt = "\n Schedule No should conatin only numbers.\n";
			if (!validObj.idValidation(scheduleNo)) {
				System.out.println(prompt);
			}

		} while (!validObj.idValidation(scheduleNo));
		int schduleNo = Integer.parseInt(scheduleNo);

		String contractNo;
		do {
			System.out.println("Contract No:");
			contractNo = sc.next();
			prompt = "\n Contract No should conatin only numbers.\n";
			if (!validObj.idValidation(contractNo)) {
				System.out.println(prompt);
			}

		} while (!validObj.idValidation(contractNo));
		int contNo = Integer.parseInt(contractNo);

		ScheduleBean scheduleBean = new ScheduleBean();

		scheduleBean.setSchedulerId(schduleNo);
		scheduleBean.setContractId(contNo);

		ContractorBean contractorBean = contractDao.searchContract(contNo);
		scheduleBean.setCustomerid(contractorBean.getCustomerId());
		scheduleBean.setProductId(contractorBean.getProductId());
		scheduleBean.setOrderId(contractorBean.getOrderId());
		scheduleBean.setDeliveryDate(contractorBean.getDeliveryDate());
		scheduleBean.setStatus("Scheduled");

		
		
		boolean addFlag = false;
		try {
			addFlag = scheduledao.addSchedule(schduleNo, scheduleBean);
			if (addFlag) {
				System.out.println("Scheduler Details Added Successfully For Date : "+scheduleBean.getDeliveryDate());
			}
		} catch (SchedulerException e) {
			System.out.println(e.getMessage());
		}

	}

}