package com.capgemini.forestrymanagementsystembyusingcollection.controller;

import java.text.ParseException;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Validation {

	public boolean passwordValidation(String password) {

		String PASSWORD_PATTERN = "((?=.*[a-z])(?=.*\\d)(?=.*[A-Z])(?=.*[@#$%!]).{8,40})";
		boolean flag = password.matches(PASSWORD_PATTERN);
		return flag;

	}

	public boolean dayValidation(String day) {

		if (day.equalsIgnoreCase("Sunday") || day.equalsIgnoreCase("Monday") || day.equalsIgnoreCase("Tuesday")
				|| day.equalsIgnoreCase("Wednesday") || day.equalsIgnoreCase("Thursday")
				|| day.equalsIgnoreCase("Friday") || day.equalsIgnoreCase("Saturday")) {
			// System.out.println("You have entered a correct day");
			return true;
		} else {
			return false;
		}

	}

	public boolean valueValidation(String idCode) {

		// String idCode=String.valueOf(id);
		String ID_PATTERN = "^[0-9]+";
		boolean flag = idCode.matches(ID_PATTERN);
		return flag;

	}

	
	public boolean idValidation(String id) {

		String ID_PATTERN = "^[0-9]+";
		boolean flag = id.matches(ID_PATTERN);
		return flag;

	}

	public boolean nameValidation(String name) {

		String USERNAME_PATTERN = "[a-zA-Z\\s]*$";
		boolean flag = name.matches(USERNAME_PATTERN);
		return flag;

	}

	public boolean addresValidation(String address) {

		String ADDRESS_PATTERN = "[#.0-9a-zA-Z\\s,]*$";

		boolean flag = address.matches(ADDRESS_PATTERN);
		return flag;

	}

	public boolean emailValidation(String email) {

		String EMAIL_PATTERN = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
		boolean flag = email.matches(EMAIL_PATTERN);
		return flag;
	}

	public boolean townValidation(String address) {

		String townPattern = "^[A-Za-z]*";

		boolean flag = address.matches(townPattern);
		return flag;

	}

	public boolean postalCodeValidation(int postalCode) {

		boolean flag = false;
		String pstCode = String.valueOf(postalCode);
		if (pstCode.length() > 6) {
			flag = false;
		} else if (pstCode.length() < 6) {
			flag = false;
		} else {
			String telephoneNumregex = "^[0-9]+";
			flag = pstCode.matches(telephoneNumregex);
		}

		return flag;

	}

	public boolean mobileNoValidation(String telephoneNume) {
		boolean flag = false;

		if (telephoneNume.length() > 10) {
			flag = false;
		} else if (telephoneNume.length() < 10) {
			flag = false;
		} else {

			String telephoneNumregex = "^(\\+91[\\-\\s]?)?[0]?(91)?[789]\\d{9}$";

			flag = telephoneNume.matches(telephoneNumregex);
		}
		return flag;
	}

	public static boolean isValidDate(String dates) {

		SimpleDateFormat sdfrmt = new SimpleDateFormat("dd-MM-yyyy");

		String datePattern = "\\d{1,2}-\\d{1,2}-\\d{4}";
		boolean isDate = dates.matches(datePattern);
		try {
			if (isDate) {
				Date inputDate = removeTime(sdfrmt.parse(dates));

				Date currentDateTime = removeTime(new Date());// new Date();

				if (inputDate.compareTo(currentDateTime) > 0) {
					return true;
				} else if (inputDate.compareTo(currentDateTime) < 0) {
					return false;
				} else {
					return true;
				}

			}

		} catch (ParseException e) {
			e.printStackTrace();
		} // if date invalid throw exception
		return false;

	}

	public static Date removeTime(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return cal.getTime();
	}



}
