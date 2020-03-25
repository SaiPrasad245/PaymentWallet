package com.capgemini.wallet.service;
import java.sql.Date;
import java.util.List;

import com.capgemini.wallet.dao.WalletUserDao;
import com.capgemini.wallet.dao.WalletUserDaoImpl;
import com.capgemini.wallet.dto.CardDetails;
import com.capgemini.wallet.dto.User;
import com.capgemini.wallet.dto.WalletTransaction;
import com.capgemini.wallet.dto.WalletUser;

public class WalletUserServiceImpl implements WalletUserService{
	WalletUserDao dao=new WalletUserDaoImpl();
	WalletUser user=new WalletUser();
	@Override
	public int addUser(WalletUser user){
		int rows=0;
		rows=dao.addUser(user);
		return rows;
	}
	public WalletUser loginUser(int userId, String pswd) {
		return dao.loginUser(userId, pswd);
	}
	@Override
	public int addCard(CardDetails card) {
		int rows=0;
		rows=dao.addCard(card);
		return rows;
	}
	@Override
	public double addMoneyToWallet(double money,int id,long cdno) {
		double rows=0;
		 rows=dao.addMoneyToWallet(money,id,cdno);
		return rows;
	}
	@Override
	public User getCurrentBalance(int id) {
		User rows=dao.getCurrentBalance(id);
		return rows;
	}
/*	@Override
	public CardDetails addCard(int id, long cdno, int cvv, double d) {
		
		return null;
	}*/
	@Override
	public boolean checkCard(int userid, long cdno1, int cvv1) {
		 boolean r=dao.checkCard(userid, cdno1, cvv1);
		return r;
	}
	@Override
	public int getTransactions(Date dot) {
		// TODO Auto-generated method stub
		return dao.getTransactions(dot);
	}
	@Override
	public int sendMoney(int userid, double money, int userid2) {
		int r=dao.sendMoney(userid, money, userid2);
		return r;
	}
	@Override
	public List<WalletTransaction> getAllTransactions() {
		
		return dao.getAllTransactions();
	}
	@Override
	public WalletTransaction getTransactionsByDate(Date dateOfTransaction) {
		
		return dao.getTransactionsByDate(dateOfTransaction);
	}
	@Override
	public int getTransactions(java.util.Date date) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public WalletTransaction getTransactionsByDate(java.util.Date date) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
