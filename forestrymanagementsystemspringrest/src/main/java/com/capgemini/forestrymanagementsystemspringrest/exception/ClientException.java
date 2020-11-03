package com.capgemini.forestrymanagementsystemspringrest.exception;

@SuppressWarnings("serial")
public class ClientException extends RuntimeException{
	
	public ClientException(String message)
	{
		super(message);
	}


}
