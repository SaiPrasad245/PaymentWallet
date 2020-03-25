package com.capgemini.wallet.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ConvertDate {
	public static Date utildate=null;
	public static Date convertDate(String date){
		try{
		SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yy");
		utildate=sdf.parse(date);
		}
		catch(ParseException e){
			e.printStackTrace();
		}
		return  utildate;
		
	}

}
