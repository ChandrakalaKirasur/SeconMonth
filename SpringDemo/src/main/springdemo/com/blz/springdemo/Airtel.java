package com.blz.springdemo;

public class Airtel implements Sim {
	@Override
	public void calling() {
		System.out.println("calling using airtel");
	}

	@Override
	public void browsing() {
		System.out.println("browsing using airtel");
	}

}
