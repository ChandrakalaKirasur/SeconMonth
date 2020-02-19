package com.blz.springdemo.model;

public class Pen {
	String name;
	public void setName(String name) {
		this.name=name;
	}
	public void prepareNote() {
		System.out.println("preparing notes");
	}
}
