package com.capgemini.wallet.exceptions;

@SuppressWarnings("serial")
public class InvalidCardNumberException extends Exception {
 public InvalidCardNumberException(){
	 super("Please enter valid card number");
 }
}
