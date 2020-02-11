package com.blz.webapp.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blz.webapp.model.Customer;
import com.blz.webapp.service.CustomerService;
import com.blz.webapp.service.impl.CustomerServiceImpl;
@WebServlet("/LoginRegister")
public class LoginRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CustomerService service;
    public LoginRegister() {
        super();
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		service=new CustomerServiceImpl();
		String userID=request.getParameter("userID");
		String passWord=request.getParameter("passWord");
		String submit=request.getParameter("submit");
		Customer c=service.getConnection(userID, passWord);
		if(submit.equals("Login")&& c!=null && c.getName()!=null) {
			request.setAttribute("message", c.getName());
			request.getRequestDispatcher("Welcome.jsp").forward(request, response);
		}
		else if(submit.equals("Register")) {
			String name=request.getParameter("name");
			userID=request.getParameter("userID");
			passWord=request.getParameter("passWord");
			c=new Customer(name,userID,passWord);
			service.insertCustomer(c);
			request.setAttribute("successMessage","Registration is done,please login");
			request.getRequestDispatcher("Home.jsp").forward(request,response);
		
		}
		else
		{
			request.setAttribute("message","Data not found ,click on Register");
			request.getRequestDispatcher("Home.jsp").forward(request,response);
		
		}
	}

}
