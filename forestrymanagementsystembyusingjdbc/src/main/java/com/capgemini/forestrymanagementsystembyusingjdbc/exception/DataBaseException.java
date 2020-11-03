package com.capgemini.forestrymanagementsystembyusingjdbc.exception;

@SuppressWarnings("serial")
public class DataBaseException extends Exception {

	String str1;

	/**
	 * 
	 * @param message
	 */
	public DataBaseException(String message) {
		str1 = message;
	}

	@Override
	public String toString() {
		return ("Issue In Connecting To The Database \n Please Try once again");
	}
}
