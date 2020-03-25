package com.capgemini.wallet.dto;

public class User {
	private  double wallet_balance;
	private  int userid;
	public User( double wallet_balance, int userid) {
	super();
	this.wallet_balance = wallet_balance;
	this.userid = userid;
	}
	public User() {
		// TODO Auto-generated constructor stub
	}
	
	public double getWallet_balance() {
	return wallet_balance;
	}
	public void setWallet_balance(double wallet_balance) {
	this.wallet_balance = wallet_balance;
	}
	public int getUserid() {
	return userid;
	}
	public void setUserid(int userid) {
	this.userid = userid;
	}
	}
