package com.capgemini.forestrymanagementsystembyusingjdbc.controller;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.capgemini.forestrymanagementsystembyusingjdbc.bean.ContractorBean;
import com.capgemini.forestrymanagementsystembyusingjdbc.bean.CustomerBean;
import com.capgemini.forestrymanagementsystembyusingjdbc.bean.HauilerBean;
import com.capgemini.forestrymanagementsystembyusingjdbc.bean.InventoryBean;
import com.capgemini.forestrymanagementsystembyusingjdbc.bean.LandBean;
import com.capgemini.forestrymanagementsystembyusingjdbc.exception.InvalidInputException;
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

public class ReportsMain {

	CustomerServices customerServices = new CustomerServicesImpl();
	InventoryServices inventoryServices = new InventoryServicesImpl();
	ContractorServices contractorServices = new ContractorServicesImpl();
	LandService landService = new LandServiceImpl();
	HauilerService hauilerService = new HauilerServiceImpl();
	Scanner sc = new Scanner(System.in);

	public void getAllReports() {
		try {
			System.out.println("Welcome To Reports Module");
			try {
				while (true) {
					System.out.println("Please Select The Module:");
					System.out.println("1.Customer");
					System.out.println("2.Products");
					System.out.println("3.Contract");
					System.out.println("4.Lands");
					// System.out.println("5.Scheduler");
					System.out.println("5.Hauiler");
					System.out.println("6.HomePage");
					int choice = sc.nextInt();
					// System.out.println("Yiu have selecte the below module==>"+choice);
					switch (choice) {
					case 1:
						List<CustomerBean> customerList = customerServices.getAllCustomers();
						if (!customerList.isEmpty()) {
							for (CustomerBean customerBean : customerList) {
								System.out.println(customerBean);
							}
						}
						break;
					case 2:
						List<InventoryBean> inventoryList = inventoryServices.getAllProduct();
						if (!inventoryList.isEmpty()) {
							for (InventoryBean inventoryBean : inventoryList) {
								System.out.println(inventoryBean);
							}
						}
						break;
					case 3:
						List<ContractorBean> contractList = contractorServices.getAllContract();
						if (!contractList.isEmpty()) {
							for (ContractorBean contractorBean : contractList) {
								System.out.println(contractorBean);
							}
						}
						break;
					case 4:
						List<LandBean> landList = landService.showLandDetails();
						if (!landList.isEmpty()) {
							for (LandBean landBean : landList) {
								System.out.println(landBean);
							}
						}
						break;
					case 5:
						List<HauilerBean> hauilerList = hauilerService.getHauiler();
						if (!hauilerList.isEmpty()) {
							for (HauilerBean hauilerBean : hauilerList) {
								System.out.println(hauilerBean);
							}
						}
						break;
					case 6:
						App app = new App();
						app.mainOperation();
						break;
					default:
						System.out.println("Please Select The Options As per the Mentioned Number");
						break;
					}

				} // While
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (NumberFormatException | InputMismatchException e) {
			throw new InvalidInputException("Please Select The Options As per the Mentioned Number");
		}
	}// Get All Reports

}
