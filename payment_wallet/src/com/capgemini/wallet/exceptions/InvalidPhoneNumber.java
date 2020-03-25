package com.capgemini.wallet.exceptions;

@SuppressWarnings("serial")
public class InvalidPhoneNumber extends RuntimeException{
	public InvalidPhoneNumber()
	{
		super("enetr a valid phone number");
	}
}
