package com.capgemini.wallet.dto;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.capgemini.wallet.exceptions.InvalidPasswordException;
import com.capgemini.wallet.exceptions.InvalidPhoneNumber;
import com.capgemini.wallet.exceptions.InvalidUserIdeException;

public class WalletUser 
{
	private  int userId;
	private  String userName;
	private String password;
	private  String phoneNo;
	private  String loginName;
	public WalletUser() {
	}
	public WalletUser(int userId, String userName, String password, String phoneNo, String loginName) {
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.phoneNo = phoneNo;
		this.loginName = loginName;
	}
	public  int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public  String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public  String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
	
		this.phoneNo = phoneNo;
	}
	
	public  String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public static void validatePhno(String phno)
	{
		
		try{
		Pattern pattern = Pattern.compile("(0/91)?[7-9][0-9]{9}");
	  Matcher matcher = pattern.matcher(phno);
	  if(matcher.matches()) 
		  System.out.println("Phone Number Valid");
		
		else throw new InvalidPhoneNumber();
	}
		catch(InvalidPhoneNumber e)
			{
			 System.out.println(e.getMessage());
			}
	}
			public static void validatePassword(String password){
			try{
				if((password.matches(".*[0-9]{1,}.*")) && (password.matches(".*[@#$%&*]{1,}.*"))&&(password.length()>=6)&&(password.length()<=8))
                   System.out.println("Given password is valid");
				else
					throw new InvalidPasswordException();
			}
			catch(InvalidPasswordException e){
				System.out.println(e.getMessage());
			}
		}
 //public static void validateUserId
 public static void validateUserId(int userId){
		try{
			int count=0;
			while(userId!=0){
				int u=userId%10;
				if(u!=0)
					count++;
				userId=userId/10;
			}
			if(count!=5)
				throw new InvalidUserIdeException();
		}
		catch(InvalidUserIdeException e){
			System.out.println(e.getMessage());
		}
	}

		}
	
		
	

