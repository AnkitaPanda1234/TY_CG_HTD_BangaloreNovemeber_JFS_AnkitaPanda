package com.cap.moduletest1.controller;

import java.util.List;
import java.util.Scanner;

import com.cap.moduletest1.baen.ProductBean;
import com.cap.moduletest1.dao.ProductDao;
import com.cap.moduletest1.factory.ProductFactory;

public class ProductMain {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		ProductDao dao=ProductFactory.instanceOfProductDaoImpl();
		while(true) {
			System.out.println("Enter the choice to move forward");
			System.out.println("press 1 for get All Product");
			System.out.println("Press 2 for search product");
			int choice=sc.nextInt();
			switch(choice)
			{
			case 1:
				List<ProductBean> c2= dao.showAllItems();
				System.out.println(c2);
				break;
			case 2:
				System.out.println("enter product name to search");
				String pdoductname=sc.next();
				 ProductBean  bean=dao.searchItems(pdoductname);
				if(bean!=null)
				{
					System.out.println("prodict id is"+bean.getProduct_id());
					System.out.println("product cost is"+bean.getProductcost());
					System.out.println("product color is"+bean.getProductcolor());	
					System.out.println("product description is"+bean.getDescription());
					System.out.println("Number of product is"+bean.getNumofproduct());
				
			}
				else
				{
					System.out.println("product name not found");
				}
		}
		
		
	}

	}
}
