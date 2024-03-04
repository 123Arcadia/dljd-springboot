package com.dljd.springboot04userservice;

import javafx.application.Application;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import javax.jws.soap.SOAPBinding;

@SpringBootApplication
public class Springboot04UserServiceApplication implements ApplicationRunner {

    public static void main(String[] args) {
//        SpringApplication.run(Springboot04UserServiceApplication.class, args);
//        通过代码，从容器中获取对象
        // 获取容器对象
//        ApplicationContext ctx = SpringApplication.run(Springboot04UserServiceApplication.class, args);
        ConfigurableApplicationContext ctx = SpringApplication.run(Springboot04UserServiceApplication.class, args);
        // 获取对象
        UserService user = (UserService) ctx.getBean("userService");
        user.doSerive("zcw!!");

//        run 方法返回值是容器对象


    }

    /**
     * 接口: ApplicationRunner
     * @param args
     * @throws Exception
     */
    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("容器对象创建好，执行 run");
    }

    /**
     * CommandLineRunner
     */
//    @Override
//    public void run(String... args) throws Exception {
//        System.out.println("容器对象创建好，执行 run");
//
//    }
}
