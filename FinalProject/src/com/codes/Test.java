package com.codes;
import java.util.Date; 
import java.text.SimpleDateFormat;  

public class Test {
	
	public static void main(String[] args) {
		
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy"); 
		Date date = new Date();
		String d1 = formatter.format(date);
		System.out.println(d1);
		System.out.println(formatter.format(date));
		
		 
	}

}
