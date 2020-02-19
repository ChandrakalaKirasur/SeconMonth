package com.blz.springdemo.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.blz.springdemo.model.Student;

public class Test {

	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("beans.xml");
		Student student=context.getBean("student",Student.class);
		student.writeNote();
	}

} 