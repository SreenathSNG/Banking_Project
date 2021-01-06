package com.configuration;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HBUtils {
	
	public static SessionFactory getSessionFactory() {
		
		
		System.out.println("Inside Configuration file");
		Configuration config = new Configuration();
		config.configure("com/configuration/hibernate.cfg.xml");
		
		SessionFactory sf = config.buildSessionFactory();
		
		return sf;
	}


}
