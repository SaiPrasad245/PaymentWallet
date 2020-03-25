package com.capgemini.wallet.utils;

public class WalletDBQueries {
public static String addUserQuery="insert into wallet_user values(?,?,?,?,?)";
public static String loginUserQuery="select * from wallet_user where user_id=? and password=?";
public static String addwallet="insert into wallet values(?,?)";
public static String getbalance="select * from wallet where user_id=?";
public static String  addmoney = " update wallet set balance=?+balance where user_id=? ";
public static String deductaccbal="update card_details set account_balance=account_balance-? where card_no=?";
public static String addcard="insert into card_details values(?,?,?,?) " ;
public static String checkcard="select * from card_details where user_id=? and card_no=? and cvv=? ";
public static String sendmoney="update wallet set balance=?+balance where user_id=? ";
public static String recievemoney="update wallet set balance=balance-? where user_id=? ";
public static String addtransactions="insert into wallet_transactions values(?,?)";
public static String gettransactions="select * from wallet_transactions";
public static String gettransactionbudate="select * from wallet_transactions where date_transaction=?";
public static String checkaccbal="select * from card_details where carc_no=?";
}
