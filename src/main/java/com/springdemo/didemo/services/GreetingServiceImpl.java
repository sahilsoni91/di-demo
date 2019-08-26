package com.springdemo.didemo.services;

public class GreetingServiceImpl implements GreetingService {

	public static final String GURUS = "Hello Guru's";

	@Override
	public String sayGreeting() {
		return GURUS;
	}
}
