package com.springdemo.didemo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.springdemo.didemo.datasourcebean.FakeDataSource;
import com.springdemo.didemo.jmsbean.FakeJmsBroker;

@Configuration
public class PropertyConfig {

	@Value("${demo.user}")
	String username;
	
	@Value("${demo.pwd}")
	String password;
	
	@Value("${demo.dburl}")
	String url;
	
	@Value("${demo.jms.user}")
    String jmsUsername;

    @Value("${demo.jms.pwd}")
    String jmsPassoword;

    @Value("${demo.jms.jmsurl}")
    String jmsUrl;
	
	@Bean
	public FakeDataSource getFakeDataSource() {
		FakeDataSource fDS = new FakeDataSource();
		fDS.setUrl(url);
		fDS.setUser(username);
		fDS.setPassword(password);
		return fDS;
	}
	
	@Bean
	public FakeJmsBroker getFakeJmsBroker() {
		FakeJmsBroker fJB = new FakeJmsBroker();
		fJB.setUrl(jmsUrl);
		fJB.setUser(jmsUsername);
		fJB.setPassword(jmsPassoword);
		return fJB;
	}
}
