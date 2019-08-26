package com.springdemo.didemo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.springdemo.didemo.services.GreetingService;
//import com.springdemo.didemo.services.GreetingServiceImpl;

@Controller
public class PropertyInjectedController {

	@Autowired
	public GreetingService greetingServiceImpl;
	
	public String sayHello() {
		return greetingServiceImpl.sayGreeting();
	}
}
