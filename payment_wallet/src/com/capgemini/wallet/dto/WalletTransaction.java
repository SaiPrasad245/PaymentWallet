package com.capgemini.wallet.dto;

import java.sql.Date;

public class WalletTransaction {
	private String status;
	private Date dateOfTransactions;
	public WalletTransaction(String status, Date dateOfTransactions) {
		super();
		this.status = status;
		this.dateOfTransactions = dateOfTransactions;
	}
	public WalletTransaction() {
		super();
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getDateOfTransactions() {
		return dateOfTransactions;
	}
	public void setDateOfTransactions(Date dateOfTransactions) {
		this.dateOfTransactions = dateOfTransactions;
	}
	

}
