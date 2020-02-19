package com.blz.springdemo;

public class Docomo implements Sim {

	@Override
	public void calling() {
		System.out.println("calling using docomo");
	}

	@Override
	public void browsing() {
		System.out.println("browsing using docomo");
	}

}
