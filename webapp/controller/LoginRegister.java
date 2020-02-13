package com.blz.webapp.controller;

import java.io.IOException;
import javax.servlet.ServletException;
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
        System.out.println("in init method");
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		service=new CustomerServiceImpl();
		String userID=request.getParameter("userID");
		 HttpSession session=request.getSession(); 
		String passWord=request.getParameter("passWord");
		String submit=request.getParameter("submit");
		Customer c=service.getConnection(userID, passWord);
		if(submit.equals("Login")&& c!=null && c.getName()!=null) {

			 //request.setAttribute("message", c.getName());
			//request.getRequestDispatcher("Welcome.jsp").include(request, response);
		
			 log.info(c.getName()+" Logged in");
			 session.setAttribute("message",c.getName()); 
			 response.sendRedirect("Welcome.jsp");
			 
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
			session.setAttribute("message", "logged out successful");
			request.getRequestDispatcher("Home.jsp").forward(request,response);
		}
		else
		{
			request.setAttribute("message","Data not found ,click on Register");
			request.getRequestDispatcher("Home.jsp").forward(request,response);
			
		}
	}

}
