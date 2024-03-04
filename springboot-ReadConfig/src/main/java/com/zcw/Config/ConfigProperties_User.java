package com.zcw.Config;

import com.zcw.pojo.UserBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 使用 @ConfigurationProperties 注解读取对应配置到新建的 Bean 对象中
 */
@Configuration
public class ConfigProperties_User {

    @Bean("userbean")
    @ConfigurationProperties(prefix = "userbean")
    public UserBean createUserBean(){
        return new UserBean();
    }
}
