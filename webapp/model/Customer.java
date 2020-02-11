package com.blz.webapp.model;

public class Customer{
	private String userID;
	private String name;
	private String passWord;
	public Customer() {}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userName) {
		this.userID = userName;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public Customer(String name, String userID, String passWord) {
		super();
		this.userID = userID;
		this.name = name;
		this.passWord = passWord;
	}
	
}
