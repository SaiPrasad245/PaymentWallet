package com.capgemini.wallet.dto;

import com.capgemini.wallet.exceptions.InvalidCardNumberException;
import com.capgemini.wallet.exceptions.InvalidCvvException;

public class CardDetails {
private int user_id;
private long card_no;
private int cvv;
private double acc_balance;
public CardDetails(int user_id, long card_no, int cvv, double acc_balance) {
	super();
	this.user_id = user_id;
	this.card_no = card_no;
	this.cvv = cvv;
	this.acc_balance = acc_balance;
}
public CardDetails() {
	super();
}
public int getUser_id() {
	return user_id;
}
public void setUser_id(int user_id) {
	this.user_id = user_id;
}
public long getCard_no() {
	return card_no;
}
public void setCard_no(long card_no) {
	this.card_no = card_no;
}
public int getCvv() {
	return cvv;
}
public void setCvv(int cvv) {
	this.cvv = cvv;
}
public double getAcc_balance() {
	return acc_balance;
}
public void setAcc_balance(double acc_balance) {
	this.acc_balance = acc_balance;
}
public static void validateCvv(int cvv){
	try{
		int count=0;
		while(cvv!=0){
			int v=cvv%10;
			if(v!=0)
				count++;
			cvv=cvv/10;
		}
		if(count!=3)
			throw new InvalidCvvException();
	}
	catch(InvalidCvvException e){
		System.out.println(e.getMessage());
	}
}
	public static void validateCard_no(long card_no){
		try{
			int count=0;
			while(card_no!=0){
				long c=card_no%10;
				if(c!=0)
					count++;
				card_no=card_no/10;
			}
			if(count!=16)
				throw new InvalidCardNumberException();
		}
		catch(InvalidCardNumberException e){
			System.out.println(e.getMessage());
		}

}
}



