package com.springdemo.didemo.controllers;

import com.springdemo.didemo.services.GreetingService;

public class ConstructorInjectedController {
	private GreetingService greetingService;
	
	public ConstructorInjectedController(GreetingService greetingService) {
		this.greetingService = greetingService;
	}
	
	String sayHello() {
		return greetingService.sayGreeting();
	}
}
