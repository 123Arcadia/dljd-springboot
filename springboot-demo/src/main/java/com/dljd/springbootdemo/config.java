package com.dljd.springbootdemo;

import com.dljd.User.MyStudent;
import org.springframework.context.annotation.*;

@Configuration
@PropertySource(value = "classpath:application.properties")
@ComponentScan(basePackages = "com.dljd.User")
public class config {
    @Bean(name = "createStu")
    public MyStudent create() {
        MyStudent s = new MyStudent();
        s.setAge(19);
        s.setName("zcw");
        s.setPhone("123");
        return s;
    }
}
