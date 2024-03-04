package com.zcw.springboot15swagger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class Springboot15SwaggerApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springboot15SwaggerApplication.class, args);

//        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
//        ctx.register(AppConfig.class);
//        ctx.refresh();
//        MyBean myBean = ctx.getBean(MyBean.class);

    }

}
