package com.zcw.springannoationdemo.config;

import com.zcw.springannoationdemo.TestDemo.User;
import com.zcw.springannoationdemo.pojo.User1;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("com.zcw.springannoationdemo")
//@PropertySource(value = "classpath:application.properties")
public class SpringConfig {
    @Bean
//    @ConfigurationProperties("user1") // 最好写在User1类上
    public User1 create_user() {
        User1 user1 = new User1();
        user1.setAge("10");
        user1.setName("create_user");
        return user1;
    }

    @Bean("cc")
    @ConfigurationProperties(prefix = "user1")
    public User1 cc_user1() {
        return new User1("zzz", "111");
        /**
         * 注意：此处仍返回properties的变量
         */
    }
//    @Bean("cc")
//    @ConfigurationProperties(prefix = "user1")
//    public User1 cc_user1() {
//        return new User1();
//    }

    /**
     * 哪怕有@ConfigurationProperties(prefix = "user1"), 也是一自己设置的优先
     * @return
     */
    @Bean("cc_01")
//    @ConfigurationProperties(prefix = "user1")
    public User1 cc_01() {
        User1 user1 = new User1();
        user1.setName("ccc");
        user1.setAge("555cccc");
        return user1;
    }
}
