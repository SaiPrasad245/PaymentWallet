package com.capgemini.wallet.exceptions;

@SuppressWarnings("serial")
public class InvalidPasswordException extends Exception{
  public InvalidPasswordException(){
  super("Please enter a valid password");
}
}