package com.codes;

import java.util.List;
import java.util.Date; 
import java.text.SimpleDateFormat; 

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.configuration.HBUtils;
import com.domains.Acc_Info;
import com.domains.Transaction_Info;


@SuppressWarnings(value = { "all" })
public class Functions {
	
	static SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy"); 
	static Date date = new Date();
	static String d1 = formatter.format(date);
	
	public static boolean debitAmount(String uname, Integer acno, Integer amnt) {
		
		Session session = HBUtils.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		
		int bal = 0, tot = 0;
		//System.out.println(d1);
		
		Query query = session.createQuery("from com.domains.Acc_Info where acc_no=?1");
		query.setParameter(1, acno);
		
		List<Acc_Info> info = query.getResultList(); 
		
		if (info.isEmpty()) {
			System.out.println("No account found");
			return false;
		}
		else {
			for(Acc_Info inf: info) {
				if (inf.getUsername().equals(uname)) {   
					System.out.println("Cannot debit money from same account");
					return false;
				}
				else {
					bal = inf.getBalance();
					if (bal < amnt) {
							System.out.println("Insufficient Balance");
							return false;
						}
					else {
						Query query1 = session.createQuery("from com.domains.Acc_Info where username=?1");
						query1.setParameter(1, uname);
						
						List<Acc_Info> info1 = query1.getResultList();
						if (info1.isEmpty()) {
							System.out.println("No account found");
							return false;
						}
						else {
							for(Acc_Info inf1: info1) {
								int bal1 = inf1.getBalance();
								
								
								tot = bal1 + amnt;
								inf1.setBalance(tot);
							}
							bal -= amnt;
							inf.setBalance(bal);
							Transaction_Info t_info = new Transaction_Info(date, "DEPOSIT", uname, amnt, tot);
							session.save(t_info);
							
						}
						
					}
				}
			}
		}
		
		tx.commit();
		session.close();
		return true;
	}
	
	
	public static boolean creditAmount(String uname, Integer acno, Integer amnt) {
		
		Session session = HBUtils.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		
		int bal1 = 0;
		
		
		Query query = session.createQuery("from com.domains.Acc_Info where acc_no=?1");
		query.setParameter(1, acno);
		
		List<Acc_Info> info = query.getResultList();  // got john details
		if (info.isEmpty()) {
			System.out.println("No account found");
			return false;
		}
		else {
			for(Acc_Info inf: info) {
				if (inf.getUsername().equals(uname)) {   
					System.out.println("Cannot credit money to same account");
					return false;
				}
				
				else {
					Query query1 = session.createQuery("from com.domains.Acc_Info where username=?1");
					query1.setParameter(1, uname);
					
					List<Acc_Info> info1 = query1.getResultList(); //got sara details
					if (info1.isEmpty()) {
						System.out.println("No account found");
						return false;
					}
					else {
						for(Acc_Info inf1: info1) {
							bal1 = inf1.getBalance();
							if (bal1 < amnt) {
									System.out.println("Insufficient Balance");
									return false;
							}
							else {
								int tot = bal1 - amnt;
								inf1.setBalance(tot);
								Transaction_Info t_info = new Transaction_Info(date, "WITHDRAW", amnt, uname, tot);
								session.save(t_info);
							}	
						}
						int bal = inf.getBalance();
						bal += amnt;
						inf.setBalance(bal);
						
					}
					
				}
			}
		}
		
		tx.commit();
		session.close();
		return true;
	}	
	
}
