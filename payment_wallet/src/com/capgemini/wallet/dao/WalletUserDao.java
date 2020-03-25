package com.capgemini.wallet.dao;
import java.sql.Date;
import java.util.List;
import com.capgemini.wallet.dto.CardDetails;
import com.capgemini.wallet.dto.User;
import com.capgemini.wallet.dto.WalletUser;
import com.capgemini.wallet.dto.WalletTransaction;
public interface WalletUserDao {
	public void openConnection();
	public int addUser(WalletUser user);
	public WalletUser loginUser(int userId,String password);
	public int addCard(CardDetails card);
	//public CardDetails addCard(int id, long cdno, int cvv, double d);
	public double addMoneyToWallet(double money,int id,long cdno);
	public User getCurrentBalance(int id);
	public boolean checkCard(int userid,long cdno1,int cvv1);
	public int sendMoney(int userid,double money,int userid2);
	public int getTransactions(Date dot);
	public List<WalletTransaction> getAllTransactions();
	public WalletTransaction getTransactionsByDate(Date dateOfTransaction);
	public void close();
	

}
