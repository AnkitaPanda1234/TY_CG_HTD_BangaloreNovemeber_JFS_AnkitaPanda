package com.cap.phonesimulator.controller;

import java.util.Scanner;

import javax.jws.soap.SOAPBinding;

import com.cap.phonesimulator.bean.ContactBean;
import com.cap.phonesimulator.factory.Factory;
import com.cap.phonesimulator.services.ContactServices;

public class ContactMain {
	public static void main(String[] args) {
		ContactServices services=Factory.instanceOfContactServicesImple();
		ContactBean bean=new ContactBean();
		Scanner sc=new Scanner(System.in);
		
		
		while(true)
		{
			System.out.println("press 1 to show all contact");
			System.out.println("press 2 to search contact");
			System.out.println("press 3 to operate on contact");
			int choice=sc.nextInt();
		switch(choice)
		{
		case 1:
			 ContactBean bean2=new ContactBean();
			 System.out.println("Add the contact details");
			 System.out.println("Enter the name ");
			 bean2.setName(sc.next());
			 System.out.println("Enter the number");
			 bean2.setNumber(sc.nextInt());
			 System.out.println("enter the group");
			 bean2.setGroup_info(sc.next());
			 boolean b=services.addContact(bean2);
			 if(b==true)
			 {
				System.out.println("customer added");
			 }
			 else
			 {
				 System.out.println("something wrong");
			 }
			break;
		case 2:
			System.out.println("Enter the name that you want to search");
			String name=sc.next();
			System.out.println("Enter the details");
			System.out.println("enter 1 for call");
			System.out.println("Enter 2 for message");
			System.out.println("Enter 3 for main menu");
		    
			
		
	}}
	}


	}

