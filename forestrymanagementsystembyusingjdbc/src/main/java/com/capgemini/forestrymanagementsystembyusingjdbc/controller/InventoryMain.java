package com.capgemini.forestrymanagementsystembyusingjdbc.controller;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.capgemini.forestrymanagementsystembyusingjdbc.bean.InventoryBean;
import com.capgemini.forestrymanagementsystembyusingjdbc.exception.InvalidInputException;
import com.capgemini.forestrymanagementsystembyusingjdbc.exception.ProductException;
import com.capgemini.forestrymanagementsystembyusingjdbc.factory.Factory;
import com.capgemini.forestrymanagementsystembyusingjdbc.service.InventoryServices;

public class InventoryMain {
	InventoryServices services = Factory.instanceOfInventoryServices();

	Scanner sc = new Scanner(System.in);
	Scanner scn = new Scanner(System.in);
	String prompt;
	Validation validObj = new Validation();

	public void inventoryOperation() {
		try {
			System.out.println("PRODUCT DETAILS");
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
					addProduct();
					break;
				case 2:
					updateProduct();
					break;
				case 3:
					viewProduct();
					break;
				case 4:
					deleteProduct();
					break;
				case 5:
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

	private void viewProduct() {
		System.out.println("Enter The Below Details To View Product");
		String productid;
		do {
			System.out.print("Product Id:");
			productid = sc.next();
			prompt = "\nProduct Id should conatin only numbers.\n";
			if (!validObj.idValidation(productid)) {
				System.err.println(prompt);
			}

		} while (!validObj.idValidation(productid));

		int prodtid = Integer.parseInt(productid);
		InventoryBean inventoryBean = null;
		try {
			inventoryBean = services.searchProduct(prodtid);
			if (inventoryBean != null) {
				System.out.println(inventoryBean);
			} else {
				System.out.println("Product Details Not Found To View");
			}
		} catch (ProductException e) {
			System.err.println(e.getMessage());
		}

	}

	private void deleteProduct() {
		System.out.println("Enter The Below Details To Delete Product");
		String productid;
		do {
			System.out.print("Product Id:");
			productid = sc.next();
			prompt = "\nProduct Id should conatin only numbers.\n";
			if (!validObj.idValidation(productid)) {
				System.err.println(prompt);
			}

		} while (!validObj.idValidation(productid));

		int prdId = Integer.parseInt(productid);

		boolean deleteFlag = false;
		try {
			deleteFlag = services.deleteProduct(prdId);
			if (deleteFlag) {
				System.out.println("Product Deleted Sucessfuly");
			}
		} catch (ProductException e) {
			System.err.println(e.getMessage());
		}

	}

	private void updateProduct() {

		System.out.println("Enter The Below Details To Update Product");
		String productid;
		do {
			System.out.print("Product Id:");
			productid = sc.next();
			prompt = "\nProduct Id should conatin only numbers.\n";
			if (!validObj.idValidation(productid)) {
				System.err.println(prompt);
			}

		} while (!validObj.idValidation(productid));

		int prdId = Integer.parseInt(productid);

		System.out.println("Select The Product Property You Want To Update");
		System.out.println("1.Name");
		System.out.println("2.Quantity");

		int productChoice = sc.nextInt();
		boolean flag = false;
		switch (productChoice) {
		case 1:

			String productName = null;
			do {
				System.out.print("Product Name:");
				if (scn.hasNextLine()) {
					productName = scn.nextLine();
				}
				prompt = "\nProduct name should contain only letters.\n";
				if (!validObj.nameValidation(productName)) {
					System.err.println(prompt);
				}

			} while (!validObj.nameValidation(productName));

			try {
				flag = services.modifyProduct(prdId, productName, "updateNameQuery");
				if (flag) {
					System.out.println("Product Name Updated sucessfuly");
				}

			} catch (ProductException e) {
				System.err.println(e.getMessage());
			}

			break;
		case 2:
			String productQuanitity;
			do {
				System.out.print("Product Quantity:");
				productQuanitity = sc.next();
				 prompt = "\nQuantity should conatin only numbers.\n";
				if (!validObj.valueValidation(productid)) {
					System.err.println(prompt);
				}

			} while (!validObj.valueValidation(productQuanitity));

			try {
				flag = services.modifyProduct(prdId, productQuanitity, "updateQuanitityQuery");
				if (flag) {
					System.out.println("Product Quantity Updated sucessfuly");
				}
			} catch (ProductException e) {
				System.out.println(e.getMessage());
			}

			break;
		default:
			System.out.println("Please Select The Options As per the Mentioned Number");
			break;

		}

	}

	private void addProduct() {

		InventoryBean inventoryBean = new InventoryBean();
		System.out.println("Enter The Below Details To Add Product");
		boolean addFlag = false;
		String productid;
		do {
			System.out.print("Product Id:");
			productid = sc.next();
			prompt = "\nProduct Id should conatin only numbers.\n";
			if (!validObj.idValidation(productid)) {
				System.err.println(prompt);
			}

		} while (!validObj.idValidation(productid));

		String productName = null;
		do {
			System.out.print("Product Name:");
			if (scn.hasNextLine()) {
				productName = scn.nextLine();
			}
			prompt = "\nProduct name should contain only letters.\n";
			if (!validObj.nameValidation(productName)) {
				System.err.println(prompt);
			}

		} while (!validObj.nameValidation(productName));

		String proQuantity;
		do {
			System.out.print("Product Quantity:");
			proQuantity = sc.next();
			 prompt = "\nQuantity should conatin only numbers.\n";
			if (!validObj.valueValidation(proQuantity)) {
				System.out.println(prompt);
			}

		} while (!validObj.valueValidation(proQuantity));

		try {
			inventoryBean.setProductId(Integer.parseInt(productid));
			inventoryBean.setProductName(productName);
			inventoryBean.setProductQuantity(Long.parseLong(proQuantity));

			addFlag = services.insertProduct(inventoryBean);
			if (addFlag) {
				System.out.println("Product Details Added Successfully");
			}
		} catch (ProductException | NumberFormatException | InputMismatchException | InvalidInputException e) {
			System.out.println(e.getMessage());
		}

	}

}
