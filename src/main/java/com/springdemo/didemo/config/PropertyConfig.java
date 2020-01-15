package com.springdemo.didemo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;

import com.springdemo.didemo.datasourcebean.FakeDataSource;
import com.springdemo.didemo.jmsbean.FakeJmsBroker;

@Configuration
//@PropertySource("classpath:datasource.properties")
@PropertySources({@PropertySource("classpath:datasource.properties"), @PropertySource("classpath:jms.properties")})
public class PropertyConfig {

	/*
	 * GetProperties from environment variables
	 */
	@Autowired
	Environment env;
	
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
	
	/*
	 * Created this bean to read properties file mentioned in PropertySource annotation
	 */
	@Bean
	public static PropertySourcesPlaceholderConfigurer propertyFileReader() {
		PropertySourcesPlaceholderConfigurer pspc = new PropertySourcesPlaceholderConfigurer();
		return pspc;
	}
	
	@Bean
	public FakeDataSource getFakeDataSource() {
		FakeDataSource fDS = new FakeDataSource();
		fDS.setUrl(env.getProperty("DBURL"));
		fDS.setUser(env.getProperty("USER"));
		fDS.setPassword(env.getProperty("PWD"));
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
