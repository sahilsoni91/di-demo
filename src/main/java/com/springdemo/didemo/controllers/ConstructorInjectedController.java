package com.springdemo.didemo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.springdemo.didemo.services.GreetingService;

@Controller
public class ConstructorInjectedController {
	private GreetingService greetingService;
	
	/*
	 * Autowired not required is optional to mention in constructor based dependency
	 */
	@Autowired
	public ConstructorInjectedController(GreetingService greetingService) {
		this.greetingService = greetingService;
	}
	
	public String sayHello() {
		return greetingService.sayGreeting();
	}
}
