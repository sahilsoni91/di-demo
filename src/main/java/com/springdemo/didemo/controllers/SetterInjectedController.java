package com.springdemo.didemo.controllers;

import com.springdemo.didemo.services.GreetingService;

public class SetterInjectedController {

	private GreetingService greetingService;
	
	public void setGreetingService(GreetingService greetingService) {
		this.greetingService = greetingService; 
	}
	
	String sayHello() {
		return greetingService.sayGreeting();
	}
}
