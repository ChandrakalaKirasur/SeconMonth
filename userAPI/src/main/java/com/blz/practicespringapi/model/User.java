package com.blz.practicespringapi.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
	@Id
	private String userID;
	
	private String useName;
	
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

	public User(String userID, String useName, String password, String phoneNum) {
		this.userID = userID;
		this.useName = useName;
		this.password = password;
		this.phoneNum = phoneNum;
	}
	
}
