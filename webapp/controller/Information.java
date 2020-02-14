package com.blz.webapp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blz.webapp.model.Customer;
import com.blz.webapp.service.CustomerService;
import com.blz.webapp.service.impl.CustomerServiceImpl;
@WebServlet("/Information")
public class Information extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CustomerService service;
    public Information() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int pageNum=Integer.parseInt(request.getParameter("page"));
		service=new CustomerServiceImpl();
		PrintWriter out=response.getWriter();
		int total=4;
		if(pageNum==1) {}
		else
		{
			pageNum=pageNum*4;
		}
		List<Customer> list=service.getInformation(pageNum,total);
	        out.print("<table border='1' cellpadding='4' width='60%'>");  
	        out.print("<tr><th>UerID</th><th>Name</th>");  
	        for(Customer e:list){  
	            out.print("<tr><td>"+e.getUserID()+"</td><td>"+e.getName()+"</td><td>");  
	        }  
	        out.print("</table>");  
	       // out.print("Page Number<input type=\"test\" name=\"page\">"); 
	        out.print("<a href='Information?page=1'>1</a> ");
	        out.print("<a href='Information?page=2'>2</a> ");  
	        out.print("<a href='Information?page=3'>3</a> ");  
	        out.close();
	}

}
