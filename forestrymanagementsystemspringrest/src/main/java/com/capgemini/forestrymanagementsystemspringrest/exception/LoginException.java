package com.capgemini.forestrymanagementsystemspringrest.exception;

@SuppressWarnings("serial")
public class LoginException extends RuntimeException{
	public LoginException(String message)
	{
		super(message);
	}


}
