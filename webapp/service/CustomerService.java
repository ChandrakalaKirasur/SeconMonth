package com.blz.webapp.service;

import com.blz.webapp.model.Customer;

public interface CustomerService {
	public Customer getConnection(String userID, String password);
	public int insertCustomer(Customer b);
}
