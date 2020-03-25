package com.capgemini.wallet.application;

import java.util.List;
import java.util.Scanner;
import java.sql.SQLException;
import com.capgemini.wallet.dto.CardDetails;
import com.capgemini.wallet.dto.User;
import com.capgemini.wallet.dto.WalletTransaction;
import com.capgemini.wallet.dto.WalletUser;
import com.capgemini.wallet.exceptions.InvalidPhoneNumber;
import com.capgemini.wallet.service.WalletUserService;
import com.capgemini.wallet.service.WalletUserServiceImpl;
import com.capgemini.wallet.utils.ConvertDate;

@SuppressWarnings("unused")
public class MainApp {
	@SuppressWarnings({ "resource", })
	public static void main(String[] args) throws SQLException, InvalidPhoneNumber {
		Scanner sc=new Scanner(System.in);
		while(true)
		{
		System.out.println("select your choice");
		System.out.println("1.sign up");
		System.out.println("2.login");
		System.out.println("3.exit");
		int n=sc.nextInt();
		switch(n)
		{
		case 1:
		{
		int rows;
		WalletUserService service=new WalletUserServiceImpl();
		System.out.println("enter user id");
		int id=sc.nextInt();
		
		System.out.println("enter name");
		String name=sc.next();
		
		System.out.println("enter password");
		String pswd=sc.next();
		WalletUser.validatePassword(pswd);
		System.out.println("enter phone no");
		String phno=sc.next();
		WalletUser.validatePhno(phno);
		System.out.println("enter login name");
		String logname=sc.next();
		WalletUser user=new WalletUser(id,name,pswd,phno,logname);
		rows = service.addUser(user);
		}break;
		case 2:
		{		
			WalletUserService service=new WalletUserServiceImpl();
			System.out.println("enter user id");
			int id=sc.nextInt();
			System.out.println("enter password");
			String pswd=sc.next();
			WalletUser user=service.loginUser(id, pswd);
			System.out.println("select your choice");
			System.out.println("1.check balance");
			System.out.println("2.add money");
			System.out.println("3.transactions");
		    int n1=sc.nextInt();
		    System.out.println("enter your choice");
		    		switch(n1){
		    		case 1 : 
		    			   User user1=service.getCurrentBalance(id);
		    		case 2 :
		    			System.out.println("1.Add Money");
		    			System.out.println("2.Add Card");
		    			int a=sc.nextInt();
		    			switch(a){
		    				case 1:
		    					WalletUser User=new WalletUser();
		    					System.out.println("Enter the Amount to be Added ");
		    					double money = sc.nextDouble();
		    				
		    					System.out.println("Enter the Card Number");
		    					long cdno1 = sc.nextLong();
		    					CardDetails.validateCard_no(cdno1);
		    					System.out.println("Enter the CVV ");
		    					int cvv1 = sc.nextInt();
		    					CardDetails.validateCvv(cvv1);
		    				boolean r=service.checkCard(id, cdno1, cvv1);
		    				if(r==true){
		    					double rows=service.addMoneyToWallet(money,id,cdno1);}
		    				else
		    					System.out.println("add your card first");
		    				break;
		    				case 2:
		    					
		    					System.out.println("Enter the Card Number");
		    					long cdno = sc.nextLong();
		    					System.out.println("Enter the CVV ");
		    					int cvv = sc.nextInt();
		    					double bal=50000.0;
		    					CardDetails card=new CardDetails(id,cdno,cvv,bal);
		    					int rows=service.addCard(card);
		    					break;
		    				default :
		    					System.out.println("Invalid Option");
		    					break;
		    					}
		    		case 3:
		    			System.out.println("eneter your choice");
		    			System.out.println("1.send money");
		    			System.out.println("2.show transaction history");
		    			int c=sc.nextInt();
		    			switch(c){
		    			case 1:
		    			 System.out.println("enter receipients id ");	
		    			 int rid=sc.nextInt();
		    			 System.out.println("enter ammount to be transfered");
		    			 double smoney=sc.nextDouble();
		    			 System.out.println("confirm your id please");
		    			 int uid=sc.nextInt();
		    			 service.sendMoney(rid, smoney, uid);
		    			 break;
		    			case 2:
		    				System.out.println("eneter your choice");
		    				System.out.println("1.show all transactions");
		    				System.out.println("2.show transaction by date");
		    				int l=sc.nextInt();
		    				switch(l)
		    				{
		    				case 1:
		    					List<WalletTransaction> wts=service.getAllTransactions();
		    					for(WalletTransaction w:wts)
		    						System.out.println(w.getDateOfTransactions()+""+w.getStatus());
		    					break;
		    				case 2:
		    					System.out.println("eneter date for transaction history");
		    					String date=sc.next();
		    					service.getTransactionsByDate(ConvertDate.convertDate(date));
		    					break;
		    					default:
		    					
		    				}
		    		} }
		    	}
		case 3:
			System.exit(0);
			break;
		default:
			System.out.println("invalid choice");
			}
		}
	}
}