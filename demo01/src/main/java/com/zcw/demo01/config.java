package com.zcw.demo01;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;

@Configuration
@ComponentScan("com.zcw.demo01")
public class config {

    @Bean
    public User User() {
        User user = new User();
        user.setAge(19);
        user.setName("zcw1");
        return user;
    }
}
