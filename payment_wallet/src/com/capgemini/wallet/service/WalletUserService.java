package com.capgemini.wallet.service;
import java.sql.Date;
import java.util.List;

import com.capgemini.wallet.dto.CardDetails;
import com.capgemini.wallet.dto.User;
import com.capgemini.wallet.dto.WalletTransaction;
import com.capgemini.wallet.dto.WalletUser;

public interface WalletUserService {

	public int addUser(WalletUser user);
	public WalletUser loginUser(int id,String pswd);
	public int addCard(CardDetails card);
	public double addMoneyToWallet(double money,int id,long cdno);
	public User getCurrentBalance(int id);
	public boolean checkCard(int userid,long cdno1,int cvv1);
	public int getTransactions(java.util.Date date);
	public int sendMoney(int userid,double money,int userid2);
	public List<WalletTransaction> getAllTransactions();
	public WalletTransaction getTransactionsByDate(java.util.Date date);
	//public CardDetails addCard(int id, long cdno, int cvv, double d);
	WalletTransaction getTransactionsByDate(Date dateOfTransaction);
	int getTransactions(Date dot);
	
	

}
