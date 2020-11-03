package com.capgemini.forestrymanagementsystembyusingcollection.controller;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.capgemini.forestrymanagementsystembyusingcollection.dao.ContractorDAO;
import com.capgemini.forestrymanagementsystembyusingcollection.dao.CustomerDAO;
import com.capgemini.forestrymanagementsystembyusingcollection.dao.HauilerDAO;
import com.capgemini.forestrymanagementsystembyusingcollection.dao.LandDAO;
import com.capgemini.forestrymanagementsystembyusingcollection.dao.ProductDAO;
import com.capgemini.forestrymanagementsystembyusingcollection.dao.SchedulerDAO;
import com.capgemini.forestrymanagementsystembyusingcollection.exception.ContractException;
import com.capgemini.forestrymanagementsystembyusingcollection.exception.CustomerException;
import com.capgemini.forestrymanagementsystembyusingcollection.exception.HauilerException;
import com.capgemini.forestrymanagementsystembyusingcollection.exception.InvalidInputException;
import com.capgemini.forestrymanagementsystembyusingcollection.exception.LandException;
import com.capgemini.forestrymanagementsystembyusingcollection.exception.ProductException;
import com.capgemini.forestrymanagementsystembyusingcollection.exception.SchedulerException;
import com.capgemini.forestrymanagementsystembyusingcollection.factory.ForestDaoManager;
public class Reports {

	static CustomerDAO customerDAO = ForestDaoManager.instanceofCustomerDAOImpl();
	static SchedulerDAO schedulerDAO = ForestDaoManager.instanceofSchedulerDAOImpl();
	static ProductDAO productDAO = ForestDaoManager.instanceofProductDAOImpl();
	static ContractorDAO contractorDAO = ForestDaoManager.instanceofContractorDAOImpl();
	static LandDAO landDAO = ForestDaoManager.instanceofLandDAOImpl();
	static HauilerDAO hauilerDAO = ForestDaoManager.instanceofHauilerDAOImpl();

	/**
	 * This Method Is Used To See All The Products By Admin
	 * 
	 * @throws GlobalException
	 */
	public void reportsMain() {
		try {
			System.out.println("WELCOME TO REPORTS MODULE");
			@SuppressWarnings("resource")
			Scanner sc = new Scanner(System.in);
			while (true) {
				System.out.println("1.Customer");
				System.out.println("2.Products");
				System.out.println("3.Contract");
				System.out.println("4.Lands");
				System.out.println("5.Scheduler");
				System.out.println("6.Hauiler");
				System.out.println("7.HomePage");
				int mainChoice = sc.nextInt();
				switch (mainChoice) {
				case 1:
					try {
						customerDAO.getCustomer();
					} catch (CustomerException e) {
						System.out.println(e.getMessage());
					}
					break;
				case 2:
					try {
						productDAO.getAllProducts();
					} catch (ProductException e) {
						System.out.println(e.getMessage());
					}
					break;
				case 3:
					try {
						contractorDAO.getAllContracts();
					} catch (ContractException e) {
						System.out.println(e.getMessage());
					}
					break;
				case 4:
					try {
						landDAO.getAllLandDetails();
					} catch (LandException e) {
						System.out.println(e.getMessage());
					}
					break;
				case 5:
					try {
						schedulerDAO.showSchedules();
					} catch (SchedulerException e) {
						System.out.println(e.getMessage());
					}
					break;

				case 6:
					try {
						hauilerDAO.getHauiler();
					} catch (HauilerException e) {
						System.out.println(e.getMessage());
					}
					break;
				case 7:
					Admin adminMain = new Admin();
					adminMain.adminMain();
					break;
				default:
					System.out.println("Please Select The Options As per the Mentioned Number");
					break;

				}
			} // WHILE
		} catch (NumberFormatException | InputMismatchException | InvalidInputException e) {
			throw new InvalidInputException("Please Select The Options As per the Mentioned Number");
		}
	}

}
