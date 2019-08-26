package com.springdemo.didemo.controllers;

import com.springdemo.didemo.services.GreetingServiceImpl;

public class PropertyInjectedController {

	public GreetingServiceImpl greetingService;
	
	String sayHello() {
		return greetingService.sayGreeting();
	}
}
