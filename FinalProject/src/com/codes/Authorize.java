package com.codes;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.configuration.HBUtils;
import com.domains.Acc_Info;

/**
 * Servlet implementation class Authorize
 */
@WebServlet("/authorize")
public class Authorize extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@SuppressWarnings(value = { "all" })
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Session session = HBUtils.getSessionFactory().openSession();
    	Transaction tx = session.beginTransaction();
    	PrintWriter out = response.getWriter();
    	RequestDispatcher rd = request.getRequestDispatcher("authorize.html");
    	
    	String cvalue = null;
    	String uname = request.getParameter("name");
    	int acc_no = Integer.parseInt(request.getParameter("acno"));
    	int cvv = Integer.parseInt(request.getParameter("cvv"));
    	int amount = Integer.parseInt(request.getParameter("amnt"));
    	
    	Query query = session.createQuery("from com.domains.Acc_Info where username=?1 and acc_no=?2 and cvv_no=?3");
    	query.setParameter(1, uname);
    	query.setParameter(2, acc_no);
    	query.setParameter(3, cvv);
    	
    	HttpSession hs = request.getSession();
    	Enumeration<String> names = hs.getAttributeNames();
    	while(names.hasMoreElements()) {
			String name = names.nextElement();
			cvalue = hs.getAttribute(name).toString();
    	}
    	List<Acc_Info> accounts = query.getResultList();
    	if (!(accounts.isEmpty()) && uname.equals(cvalue)) {
    		if (amount < 100000) {
    			out.print("<script type=\"text/javascript\">");
    		    out.print("alert('Authorized successfully');");
    		    out.print("</script>");
    			rd.include(request, response);
    		}
    		else {
    			out.print("<script type=\"text/javascript\">");
    		    out.print("alert('Amount exceeded the limit');");
    		    out.print("</script>");
    			rd.include(request, response);
 
    		}
    	}
    	else {
    		out.print("<script type=\"text/javascript\">");
		    out.print("alert('Invalid input');");
		    out.print("</script>");
			rd.include(request, response);
    		
    	}
    	tx.commit();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
