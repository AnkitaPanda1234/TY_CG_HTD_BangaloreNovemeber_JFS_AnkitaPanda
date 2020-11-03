package com.capgemini.forestrymanagementsystemspringrest.exception;

@SuppressWarnings("serial")
public class CustomerException extends RuntimeException {
	
	public CustomerException(String message)
	{
		super(message);
	}

}
