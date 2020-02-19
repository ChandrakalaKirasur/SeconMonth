package com.blz.webapp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.blz.webapp.model.Customer;
import com.blz.webapp.service.CustomerService;
import com.blz.webapp.service.impl.CustomerServiceImpl;
public class LoginRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Logger log=LogManager.getLogger(LoginRegister.class);
	private CustomerService service;
    public LoginRegister() {
        super();
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		service=new CustomerServiceImpl();
		PrintWriter out=response.getWriter();
		String userID=request.getParameter("userID");
		 HttpSession session=request.getSession(); 
		String passWord=request.getParameter("passWord");
		String submit=request.getParameter("submit");
		Customer c=service.getConnection(userID, passWord);
		if(submit.equals("Login")&& c!=null && c.getName()!=null) {
			session.setAttribute("user", userID);
			Cookie user=new Cookie("user", userID); 
			response.addCookie(user);
			log.info(c.getName()+" Logged in");
			 request.setAttribute("message", c.getName());
			 request.getRequestDispatcher("Welcome.jsp").forward(request,response);
			 			 
		}
		else if(submit.equals("Register")) {
			String name=request.getParameter("name");
			c=new Customer(name,userID,passWord);
			service.insertCustomer(c);
			log.info(name+" registered");
			request.setAttribute("successMessage","Registration is done,please login");
			request.getRequestDispatcher("Home.jsp").forward(request,response);
		
		}
		else if(submit.equals("Logout"))
		{
			log.info("logged out");
			session.invalidate();
			request.getRequestDispatcher("Home.jsp").forward(request,response);
		}
		else if(submit.equals("Info"))
		{
			 request.getRequestDispatcher("information.jsp").forward(request,response);
		}
		else
		{
			request.setAttribute("message","Data not found ,click on Register");
			request.getRequestDispatcher("Home.jsp").forward(request,response);
			
		}
	}

}
