package com.blz.springdemo.model;

public class Student {
	String name;
	int id;
	Pen pen;
	public void setName(String name) {
		this.name=name;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setPen(Pen pen) {
		this.pen=pen;
	}
	public void writeNote() {
		pen.prepareNote();
	}

}
