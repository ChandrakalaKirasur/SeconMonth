package com.blz.webapp.service.impl;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.blz.webapp.model.Customer;
import com.blz.webapp.service.CustomerService;

import java.sql.Connection;
public class CustomerServiceImpl implements CustomerService
{
	Logger log=LogManager.getLogger(CustomerServiceImpl.class);
	public Customer getConnection(String userID, String password)
	{
		Customer bean=new Customer();
		try{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/college","chandu","1234");
		log.info("connection established");
		PreparedStatement ps=con.prepareStatement("select * from college.customer where userID=? and password=?");
		ps.setString(1, userID);
		ps.setString(2, password);
		ResultSet rs=ps.executeQuery();
		while(rs.next()) {
			bean.setUserID(rs.getString(1));
			bean.setName(rs.getString(2));
			bean.setPassWord(rs.getString(3));
		}
	}
	catch(Exception e)
	{
		log.error("exception occured in fetching");
	}
		return bean;
}
public int insertCustomer(Customer b)
{
 int status=0;
	try{
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/college","chandu","1234");
	PreparedStatement ps=con.prepareStatement("insert into college.customer values(?,?,?)");
	ps.setString(1,b.getUserID());
	ps.setString(2,b.getName());
	ps.setString(3,b.getPassWord());
	status = ps.executeUpdate();
	con.close();
	}
	catch(Exception e)
	{
		log.error("exception occured in inserting");
	}
	return status;
}
}
