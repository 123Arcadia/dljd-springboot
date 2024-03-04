package com.zcw.demo01;

import com.zcw.demo01.Service.Service;
import org.junit.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class Demo01Application {


	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(Demo01Application.class, args);
		User user = (User) ctx.getBean("User");
		System.out.println("user = " + user);
	}

	@Test
	public void test_Service() {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(config.class);
		Service service = (Service) ctx.getBean("saveService");
		service.save(); // sout : save()...
	}



}
