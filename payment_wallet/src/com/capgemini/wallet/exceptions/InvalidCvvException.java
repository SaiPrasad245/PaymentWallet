package com.capgemini.wallet.exceptions;

@SuppressWarnings("serial")
public class InvalidCvvException extends Exception {
 public InvalidCvvException(){
	 super("Please enter a valid cvv");
 }
}
