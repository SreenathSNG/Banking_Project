<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@page import="org.hibernate.Session, java.text.SimpleDateFormat, java.util.Date, java.util.List, org.hibernate.query.Query, com.configuration.HBUtils,com.domains.Acc_Info, com.domains.Transaction_Info" %><!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Statement</title>
<link rel="stylesheet" href="css/styles.css">
<link href="https://fonts.googleapis.com/css2?family=Merriweather&family=Montserrat&family=Sacramento&display=swap" rel="stylesheet">
</head>

<%@include file="statement.jsp" %>
<%!
	String from_date, to_date;
	Date d1 = null, d2 =  null;
	
	Date date = null;
	String desc;
	int withdraw, deposit, balance;
	
	Query query;
	List<Transaction_Info> ls;
	
	int i;
%>

<%
	Session s1 = HBUtils.getSessionFactory().openSession();
	String uname = pageContext.getAttribute("uname",PageContext.SESSION_SCOPE).toString();
	
	from_date = request.getParameter("from_date");
	to_date = request.getParameter("to_date");
	
	
	
	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");  
	try {
		d1 = formatter.parse(from_date);
		d2 = formatter.parse(to_date);
	} 
	catch (Exception e) {
		
		System.out.println("Error reading date");
	}
	
	query = s1.createQuery("from com.domains.Transaction_Info where username=?1 and (date between :from_date and :to_date)");
	query.setParameter(1, uname);
	query.setParameter("from_date", d1);
	query.setParameter("to_date", d2);
	ls = query.getResultList();
	i = 1;
	%>
	<body>
	<table class="s_table">
		<tr>
		<th>SL No</th>
		<th>Date</th>
		<th>Description</th>
		<th>Deposit</th>
		<th>Withdraw</th>
		<th>Balance</th>
		 </tr>	
	
	
	<%
	SimpleDateFormat formatter1 = new SimpleDateFormat("dd-MM-yyyy"); 
	for (Transaction_Info tinfo: ls) {
		
		date = tinfo.getDate();
		String date1 = formatter1.format(tinfo.getDate());
		desc = tinfo.getDescription();
		deposit = tinfo.getDeposit();
		withdraw = tinfo.getWithdraw();	
		balance = tinfo.getBalance();
	%>
		<tr>
		<td><%=i %></td>
		<td><%=date1 %></td>
		<td><%=desc %></td>
		<td><%=deposit %></td>
		<td><%=withdraw %></td>
		<td><%=balance %></td>
		 </tr>
	<%
		i++;	
	}
	s1.close();
	%>
</table>
</body>
</html>