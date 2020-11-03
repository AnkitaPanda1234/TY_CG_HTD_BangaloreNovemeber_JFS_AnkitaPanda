package com.capgemini.forestrymanagementsystembyusingcollection.controller;

import java.util.InputMismatchException;


import java.util.Scanner;

import com.capgemini.forestrymanagementsystembyusingcollection.exception.InvalidInputException;


public class TestMain {

	public static void main() {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("....Welcome To Forestry Management System....");
		System.out.println("Please Select The Role You Want To Login ");
		System.out.println("1.Admin");
		System.out.println("2.Client");
		System.out.println("3.Scheduler");
		try {
			int options = sc.nextInt();
			switch (options) {
			case 1:

				Admin adminMain = new Admin();
				adminMain.adminMain();
				break;

			case 2:
				User clientMain = new User();
				clientMain.client();
				break;
			case 3:
				SchedulerMain schedulerMain = new SchedulerMain();
				schedulerMain.schedueDetails();
				break;
			default:
				System.err.println("Please Select The Options As per the Mentioned Number");
				break;
			}// End OF Switch
		} catch (NumberFormatException | InputMismatchException | InvalidInputException e) {
			throw new InvalidInputException("Please Select The Options As per the Mentioned Number");

		}

	}

}
