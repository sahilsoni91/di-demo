package com.springdemo.didemo.controllers;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.springdemo.didemo.services.GreetingServiceImpl;

public class PropertyInjectedControllerTest {
	
	private PropertyInjectedController propertyInjectedController;
	
	@Before
	public void setUp() throws Exception{
		this.propertyInjectedController = new PropertyInjectedController();
		this.propertyInjectedController.greetingService = new GreetingServiceImpl();
	}
	
	@Test
	public void testGreet() throws Exception{
		assertEquals(GreetingServiceImpl.GURUS, propertyInjectedController.sayHello());
	}
}
