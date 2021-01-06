package com.codes;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;






@WebServlet("/transaction")
public class Transaction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher rd = request.getRequestDispatcher("transaction.html");
		PrintWriter out = response.getWriter();
		Integer accno = Integer.parseInt(request.getParameter("acno"));
		Integer amnt = Integer.parseInt(request.getParameter("amount"));
		String debit = request.getParameter("debit");
		String cvalue = null;
		boolean status;
		
		HttpSession hs = request.getSession();
		Enumeration<String> names = hs.getAttributeNames();
		
		while(names.hasMoreElements()) {
			//System.out.println("Inside HttpSession list");
			String name = names.nextElement();
			cvalue = hs.getAttribute(name).toString();
			
		}
		
		
		if (debit != null) {
			status = Functions.debitAmount(cvalue,accno,amnt);
			if (status == true) {
				//out.print("<p style=color:red;font-size:18px;font-family:verdana;text-align:center>Amount Debited Successfully</p>");
				rd.include(request, response);
				out.print("<script type=\"text/javascript\">");
			    out.print("alert('Amount debitted successfully');");
			    out.print("</script>");
			   
			}
			else {
				//out.print("<p style=color:red;font-size:18px;font-family:verdana;text-align:center>Cannot Perform Operation</p>");
				rd.include(request, response);
				out.print("<script type=\"text/javascript\">");
			    out.print("alert('Invalid input, cannot perform operation');");
			    out.print("</script>");
			}	
		}
		else {
			status = Functions.creditAmount(cvalue,accno,amnt);
			if (status == true) {
				//out.print("<p style=color:red;font-size:18px;font-family:verdana;text-align:center>Amount Credited Successfully</p>");
				rd.include(request, response);
				out.print("<script type=\"text/javascript\">");
			    out.print("alert('Amount credted successfully');");
			    out.print("</script>");
			}
			else {
				//out.print("<p style=color:red;font-size:18px;font-family:verdana;text-align:center>Cannot Perform Operation</p>");
				rd.include(request, response);
				out.print("<script type=\"text/javascript\">");
			    out.print("alert('Invalid input, cannot perform operation');");
			    out.print("</script>");
			}	
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
