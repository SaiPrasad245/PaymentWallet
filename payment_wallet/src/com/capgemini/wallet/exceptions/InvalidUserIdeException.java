package com.capgemini.wallet.exceptions;

@SuppressWarnings("serial")
public class InvalidUserIdeException extends Exception {
  public InvalidUserIdeException(){
	  super("Please enter a valid userid");
  }
}
