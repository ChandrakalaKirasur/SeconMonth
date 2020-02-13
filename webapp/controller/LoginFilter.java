package com.blz.webapp.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class LoginFilter implements Filter{

	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		PrintWriter out=response.getWriter();
		String password=request.getParameter("passWord");  
		char[] c=password.toCharArray();
	    if(c.length>=8){  
	    	for(int i=0;i<c.length;i++) {
	    		if((int)c[i]>64 || (int)c[i]<91) {
	    			out.println("atleast one capital letter should be there is ur password");
	    		}
	    	}
	    	chain.doFilter(request, response);//sends request to next resource
	    } 
	    else
	    {
	    	out.println("password should contains atleast 8 character");
	    }
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
	}

}
