package com.bridgelabz.springapi.model;

public class User {
	
	private String useName;
	private String userID;
	private String password;
	private String phoneNum;
	public User() {
		
	}
	
	public String getUseName() {
		return useName;
	}
	public void setUseName(String useName) {
		this.useName = useName;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	public User(String useName, String userID, String password, String phoneNum) {
		this.useName = useName;
		this.userID = userID;
		this.password = password;
		this.phoneNum = phoneNum;
	}
	
}
