package com.blz.springdemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSim {

	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("beans.xml");
		Sim sim=context.getBean("sim",Sim.class);
		sim.browsing();
		sim.calling();
	}

}