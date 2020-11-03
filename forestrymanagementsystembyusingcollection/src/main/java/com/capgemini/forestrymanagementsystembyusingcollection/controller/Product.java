package com.capgemini.forestrymanagementsystembyusingcollection.controller;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.capgemini.forestrymanagementsystembyusingcollection.baen.ProductBean;
import com.capgemini.forestrymanagementsystembyusingcollection.dao.ProductDAO;
import com.capgemini.forestrymanagementsystembyusingcollection.exception.InvalidInputException;
import com.capgemini.forestrymanagementsystembyusingcollection.exception.ProductException;
import com.capgemini.forestrymanagementsystembyusingcollection.factory.ForestDaoManager;
public class Product {

	static ProductDAO dao = ForestDaoManager.instanceofProductDAOImpl();
	Validation validObj = new Validation();
	String prompt;
	Scanner sc = new Scanner(System.in);
	Scanner scn = new Scanner(System.in);

	public void product() {
		try {
			System.out.println("Welcome To Product Page");
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
					addProduct();
					break;
				case 2:
					modifyProduct();
					break;
				case 3:
					searchProduct();
					break;
				case 4:
					deleteProduct();
					break;
				case 5:
					TestMain.main();
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

	private void deleteProduct() {
		boolean deletFlag = false;
		String productid;
		do {
			System.out.print("Enter Product Id To Delete:");
			productid = sc.next();
			prompt = "\nProduct Id should conatin only numbers.\n";
			if (!validObj.idValidation(productid)) {
				System.err.println(prompt);
			}

		} while (!validObj.idValidation(productid));

		try {
			deletFlag = dao.deleteProduct(Integer.parseInt(productid));
			if (deletFlag) {
				System.out.println("Product Details Deleted");
			} else {
				System.err.println("Product Id Not Found To Delete");
			}
		} catch (ProductException e) {
			System.out.println(e.getMessage());
		}

	}

	private void modifyProduct() {
		boolean updateFlag = false;

		ProductBean productBean = new ProductBean();
		String productid;
		do {
			System.out.println("Enter Product Id To View The Update Product Details");
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
				System.err.println(prompt);
			}

		} while (!validObj.valueValidation(proQuantity));

		try {
			productBean.setProductId(Integer.parseInt(productid));
			productBean.setProductName(productName);
			productBean.setProductQuantity(Long.parseLong(proQuantity));

			updateFlag = dao.modifyproduct(Integer.parseInt(productid), productBean);
			if (updateFlag) {
				System.out.println("Product Details Updated Successfully");
			}
		} catch (ProductException | NumberFormatException e) {
			System.err.println(e.getMessage());

		}

	}

	private void searchProduct() {
		ProductBean productBean = null;
		String productid;
		do {
			System.out.print("Enter Product Id To View The Product Details : ");
			productid = sc.next();
			prompt = "\nProduct Id should conatin only numbers.\n";
			if (!validObj.idValidation(productid)) {
				System.err.println(prompt);
			}

		} while (!validObj.idValidation(productid));

		try {
			productBean = dao.searchProduct(Integer.parseInt(productid));
			if (productBean != null) {
				System.out.println(productBean);
			} else {
				System.out.println("Product Id :" + productid + " Not Found To View");
			}
		} catch (ProductException e) {
			System.err.println(e.getMessage());

		}
	}

	private void addProduct() {

		System.out.println("Enter The Below Details To Add Product");
		ProductBean productBean = new ProductBean();
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
				System.err.println(prompt);
			}

		} while (!validObj.valueValidation(proQuantity));

		try {
			productBean.setProductId(Integer.parseInt(productid));
			productBean.setProductName(productName);
			productBean.setProductQuantity(Long.parseLong(proQuantity));

			addFlag = dao.addProduct(productBean, Integer.parseInt(productid));
			if (addFlag) {
				System.out.println("Product Details Added Successfully");
			}
		} catch (ProductException | NumberFormatException e) {
			System.err.println(e.getMessage());

		}

	}

}
