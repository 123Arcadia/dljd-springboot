package com.dljd.config;

import com.dljd.vo.Student;
import com.dljd.vo.User;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.*;

@Configuration
@ImportResource(value = {"classpath:applicationContext.xml", "classpath:beans.xml"})
@PropertySource(value = "classpath:config.properties")
@ComponentScan(basePackages = "com.dljd.vo")
public class SpringConfig {

    @Bean
    public Student createStudent() {
        Student s1 = new Student();
        s1.setAge(26);
        s1.setName("张三");
        s1.setSex("男");
        return s1;
    }

    @Bean(name = "stu_01")
    public Student createStudent_01() {
        Student s2 = new Student();
        s2.setSex("女");
        s2.setName("stu_01");
        s2.setAge(26);
        return s2;
    }

    @Bean("cc_user")
    public User createUser() {
        return new User("zzzz", "111");
    }

}
