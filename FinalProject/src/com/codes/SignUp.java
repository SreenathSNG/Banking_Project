package com.codes;

import java.io.IOException;
import java.io.PrintWriter;



import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.configuration.HBUtils;
import com.domains.Basic_Info;

/**
 * Servlet implementation class SignUp
 */
@WebServlet("/signup")
public class SignUp extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Session session = HBUtils.getSessionFactory().openSession();
		Transaction tnx = session.beginTransaction();
		
		String name = request.getParameter("uname");
		String dob = request.getParameter("dob");
		String address = request.getParameter("addr");
		String email = request.getParameter("email");
		String uid = request.getParameter("uid");
		String pwd = request.getParameter("pwd");
		String acc_type = request.getParameter("acc");
		
		PrintWriter out = response.getWriter();
		
		try {
			Basic_Info info = new Basic_Info(name,dob,address,email,uid,pwd,acc_type);
			session.save(info);
			tnx.commit();
			RequestDispatcher rd = request.getRequestDispatcher("index.html");
			rd.include(request, response); 
			out.print("<h2>Account Creation Successful</h2>");
		}
		catch (Exception e) {
			
			out.print("<h2>Unable to Create Account</h2>");
		}
			
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
