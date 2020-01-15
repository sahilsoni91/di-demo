package com.springdemo.didemo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;

import com.springdemo.didemo.datasourcebean.FakeDataSource;

@Configuration
@PropertySource("classpath:datasource.properties")
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
}
