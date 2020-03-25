package com.capgemini.wallet.dao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.capgemini.wallet.dto.CardDetails;
import com.capgemini.wallet.dto.User;
import com.capgemini.wallet.dto.WalletTransaction;
import com.capgemini.wallet.dto.WalletUser;
import com.capgemini.wallet.utils.WalletDBQueries;

public class WalletUserDaoImpl implements WalletUserDao{
	private PreparedStatement pst;
	private Connection conn;
	private ResultSet result;

	@Override
	public void openConnection() {
	
		 try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				String url="jdbc:oracle:thin:@localhost:1521:xe";
				 conn=DriverManager.getConnection(url,"pranav","pranav986");
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
	}
	@Override
	public int addUser(WalletUser user) {
		openConnection();
		try {
		
			pst=conn.prepareStatement(WalletDBQueries.addUserQuery);
			pst.setInt(1,user.getUserId());
			pst.setString(2, user.getUserName());
			pst.setString(3, user.getPassword());
			pst.setString(4, user.getPhoneNo());
			pst.setString(5, user.getLoginName());
			pst.executeUpdate();
			pst=conn.prepareStatement(WalletDBQueries.addwallet);
			pst.setInt(1, user.getUserId());
			pst.setDouble(2, 0);
			pst.executeUpdate();
			System.out.println("account created");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return 0;
	}

	
	@Override
	public void close() {
	try {
		conn.close();
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
		}

	@Override
	public WalletUser loginUser(int userId,String password) {
		openConnection();
		WalletUser user=null;
		try {
			pst=conn.prepareStatement(WalletDBQueries.loginUserQuery);
			pst.setInt(1,userId );
			pst.setString(2, password );
			result =pst.executeQuery();
			if(result.next()){
				user=new WalletUser();
				user.setUserId(result.getInt(1));
				user.setUserName(result.getString(2));
				user.setPassword(result.getString(3));
				user.setPhoneNo(result.getString(4));
				user.setLoginName(result.getString(5));
				System.out.println("welcome "+result.getString(5));	
			}
			else
				System.out.println("user not found");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return user;	
	}
	User user1 = new User();
	@Override
	public int addCard(CardDetails card) {
		try {
			pst=conn.prepareStatement(WalletDBQueries.addcard);
		pst.setInt(1, card.getUser_id());
		pst.setLong(2, card.getCard_no());
		pst.setInt(3, card.getCvv());
		pst.setDouble(4, card.getAcc_balance());
		pst.executeUpdate();
		} catch (SQLException e) {
		e.printStackTrace();
		}
		return 0;
		}
	@Override
	public double addMoneyToWallet(double money,int id,long cdno) {
		try {
			pst=conn.prepareStatement(WalletDBQueries.checkaccbal);
			pst.setLong(1, cdno);
			result=pst.executeQuery();
			if(result.next())
			{
			 double bal=result.getDouble(4);
			 if(bal>money){
			pst=conn.prepareStatement(WalletDBQueries.addmoney);
			pst.setDouble(1, money);
			pst.setInt(2,id);
			pst.executeUpdate();
			pst=conn.prepareStatement(WalletDBQueries.deductaccbal);
			pst.setDouble(1, money);
			pst.setLong(2, cdno);
			pst.executeUpdate();
			 }
			 else
				 System.out.println("insufficient balance");
		   } 
			else
				System.out.println("card doesn't exist");
		}
			catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return 0;
	}
	@Override
	public User getCurrentBalance(int id) {
		try {
			
			pst=conn.prepareStatement(WalletDBQueries.getbalance);
			pst.setInt(1, id);
			result=pst.executeQuery();
			while(result.next())
			{
				User user1=new User();
				user1.setUserid(result.getInt(1));
				user1.setWallet_balance(result.getDouble(2));
			
			System.out.println(result.getDouble(2));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return user1;
	}

	@Override
	public boolean checkCard(int userid, long cdno1, int cvv1) {
		boolean x=false;
		try {
			
			pst=conn.prepareStatement(WalletDBQueries.checkcard);
			pst.setInt(1, userid);
			pst.setLong(2,cdno1);
			pst.setInt(3, cvv1);
			result=pst.executeQuery();
			if(result.next()){
				
				x=true;}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return x;
	}
	@Override
	public int getTransactions(Date dot) {
		
		return 0;
	}
	@Override
	public int sendMoney(int userid, double money,int userid2) {
		try {
			pst=conn.prepareStatement(WalletDBQueries.sendmoney);
			pst.setDouble(1, money);
			pst.setInt(2, userid);
			pst.executeUpdate();
			pst=conn.prepareStatement(WalletDBQueries.recievemoney);
			pst.setDouble(1, money);
			pst.setInt(2, userid2);
			pst.executeUpdate();
			pst=conn.prepareStatement(WalletDBQueries.addtransactions);
			pst.setString(2, "success");			
			java.time.LocalDate d = java.time.LocalDate.now();
			@SuppressWarnings("deprecation")
			Date d1 = new Date(d.getYear(),d.getMonthValue(),d.getDayOfMonth());
			pst.setDate(1, d1);
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return 0;
	}
	@Override
	public List<WalletTransaction> getAllTransactions() {
		List<WalletTransaction>transactions=new ArrayList<>();
		try {
			pst=conn.prepareStatement(WalletDBQueries.gettransactions);
			result=pst.executeQuery();
			while(result.next())
			{
				WalletTransaction wt=new WalletTransaction();
				wt.setDateOfTransactions(result.getDate(1));
				wt.setStatus(result.getString(2));
				transactions.add(wt);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return transactions;
	}
	@SuppressWarnings("deprecation")
	@Override
	public WalletTransaction getTransactionsByDate(Date dateOfTransaction) {
		try {
			pst=conn.prepareStatement(WalletDBQueries.gettransactionbudate);
			pst.setDate(1,new java.sql.Date(dateOfTransaction.getYear(),dateOfTransaction.getMonth(),dateOfTransaction.getDate()));
			result=pst.executeQuery();
			if(result.next())
			{
				WalletTransaction wt=new WalletTransaction();
				wt.setDateOfTransactions(result.getDate(1));
				wt.setStatus(result.getString(2));
				System.out.println(result.getDate(1)+""+result.getString(2));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	}
	

