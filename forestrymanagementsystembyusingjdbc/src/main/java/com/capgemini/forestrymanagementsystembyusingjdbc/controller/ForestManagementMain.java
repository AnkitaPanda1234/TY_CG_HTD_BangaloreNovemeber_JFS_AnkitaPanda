package com.capgemini.forestrymanagementsystembyusingjdbc.controller;

import java.util.InputMismatchException;

import com.capgemini.forestrymanagementsystembyusingjdbc.exception.InvalidInputException;

public class ForestManagementMain {
	public static void main(String[] args) {
		try {

			App app = new App();
			app.mainOperation();

		} catch (NumberFormatException | InputMismatchException | InvalidInputException e) {
			System.err.println(e.getMessage());
		}

	}

}
