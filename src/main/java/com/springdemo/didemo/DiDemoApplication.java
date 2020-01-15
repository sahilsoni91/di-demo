package com.springdemo.didemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.springdemo.didemo.controllers.ConstructorInjectedController;
import com.springdemo.didemo.controllers.MyController;
import com.springdemo.didemo.controllers.PropertyInjectedController;
import com.springdemo.didemo.controllers.SetterInjectedController;
import com.springdemo.didemo.datasourcebean.FakeDataSource;

/*
 * Implements CommandLineRunner interface to run as a console application
 */
@SpringBootApplication
public class DiDemoApplication implements CommandLineRunner{

	//	public static void main(String[] args) {
	//		ApplicationContext ctx = SpringApplication.run(DiDemoApplication.class, args);
	//		MyController controller = (MyController)ctx.getBean("myController");
	//		
	//		System.out.println(controller.hello());
	//		System.out.println(ctx.getBean(PropertyInjectedController.class).sayHello());
	//		System.out.println(ctx.getBean(SetterInjectedController.class).sayHello());
	//		System.out.println(ctx.getBean(ConstructorInjectedController.class).sayHello());
	//		
	//	}

	@Autowired
	ApplicationContext ctx;

	public static void main(String[] args) {
		SpringApplication.run(DiDemoApplication.class, args);
	}

	@Override
	public void run(String... args) {
		MyController controller = (MyController)ctx.getBean("myController");

		System.out.println(controller.hello());
		System.out.println(ctx.getBean(PropertyInjectedController.class).sayHello());
		System.out.println(ctx.getBean(SetterInjectedController.class).sayHello());
		System.out.println(ctx.getBean(ConstructorInjectedController.class).sayHello());
		
		System.out.println("Properties File Loading:");
		FakeDataSource fakeDataSource = (FakeDataSource)ctx.getBean(FakeDataSource.class);
		System.out.println("URL: " + fakeDataSource.getUrl());
		System.out.println("Username: " + fakeDataSource.getUser());
		System.out.println("Password: " + fakeDataSource.getPassword());
	}


}
