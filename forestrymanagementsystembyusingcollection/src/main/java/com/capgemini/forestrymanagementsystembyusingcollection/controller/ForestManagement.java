package com.capgemini.forestrymanagementsystembyusingcollection.controller;

import java.util.InputMismatchException;

import com.capgemini.forestrymanagementsystembyusingcollection.exception.InvalidInputException;

public class ForestManagement {
	public static void main(String[] args) {
		try {
			TestMain.main();
		} catch (NumberFormatException | InputMismatchException | InvalidInputException e) {
			System.out.println(e.getMessage());
			TestMain.main();
		}
	}

}
