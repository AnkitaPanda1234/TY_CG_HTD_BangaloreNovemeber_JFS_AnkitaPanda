package com.cap.moduletest1.controller;

import java.util.List;
import java.util.Scanner;

import com.cap.moduletest1.baen.ProductBean;
import com.cap.moduletest1.dao.ProductDao;
import com.cap.moduletest1.factory.ProductFactory;

public class ProductMain2 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		ProductDao dao=ProductFactory.instanceOfProductDaoImpl();
		while(true)
		{
			System.out.println("Welcome to Flipcart");
			System.out.println("press 1 to show All product");
			System.out.println("press 2 to search product");
			
			int choice=sc.nextInt();
			switch(choice)
			{
			case 1:
				List<ProductBean> l1=dao.showAllItems();
				if(l1!=null)
				{
					for (ProductBean productBean : l1) {
						System.out.println(productBean);
						
					}
					
				}
				else
				{
					System.out.println("no data found");
				}
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
					System.out.println("1 for buy");
					System.out.println("2 for search");
					System.out.println("3 for mainmenu");
					int choice1=sc.nextInt();
					switch(choice1)
					{
					case 1:
						System.out.println("enter the contact details to add");
						ProductBean bean2=new ProductBean();
						System.out.println("enter the productid");
					    bean2.setProduct_id(sc.nextInt());
					    System.out.println("enter the product name");
					    bean2.setPdoductname(sc.next());
					    System.out.println("enter the product cost");
					    bean2.setProductcost(sc.nextDouble());
					    System.out.println("enter the product color");
					    bean2.setProductcolor(sc.next());
					    System.out.println("enter the description");
					    bean2.setDescription(sc.next()); 
					    System.out.println("enter the number of product");
					    bean2.setNumofproduct(sc.nextInt());
						
                         boolean b= dao.buyProduct(bean2);
                         if(b==true)
                         {
                        	 System.out.println("buy sucessfully");
                         }
                         else
                         {
                        	 System.out.println("something wromg");
                         }
						break;
					case 2:
						System.out.println("enter product name to search");
						String pdoductname2=sc.next();
						 ProductBean  bean3=dao.searchItems(pdoductname);
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
					case3:
						ProductMain.main(args);
				}
					}
			
				
				
			}
		}
		
		
		
	}

}
