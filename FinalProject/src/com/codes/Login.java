package com.codes;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.configuration.HBUtils;

/**
 * Servlet implementation class Login
 */
@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;   
	
	@SuppressWarnings(value = { "all" })
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Session session = HBUtils.getSessionFactory().openSession();
    	Transaction tx = session.beginTransaction();
    	PrintWriter out = response.getWriter();
		
    	String uname = request.getParameter("uname");
		String pwd = request.getParameter("pwd");
		
		
		Query query = session.createQuery("from com.domains.Basic_Info where username=?1 and password=?2");
		
		query.setParameter(1, uname);
		query.setParameter(2, pwd);
		
		List results = query.list();
		if (!(results.isEmpty())) {
			
			
			HttpSession hs = request.getSession();
			hs.setAttribute("uname", uname);
			/*Cookie c1 = new Cookie("uname", uname);
			response.addCookie(c1);*/
			
			//RequestDispatcher rd = request.getRequestDispatcher("homepage.html");
			RequestDispatcher rd = request.getRequestDispatcher("homepage.jsp");
			rd.forward(request, response);	
		}

		else {
			
		    RequestDispatcher rd = request.getRequestDispatcher("index.html");
		    rd.include(request, response);
		    out.print("<script type=\"text/javascript\">");
		    out.print("alert('Username or password incorrect, please try again');");
		    out.print("</script>");
		}	
		
		}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
