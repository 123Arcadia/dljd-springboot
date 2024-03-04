package com.zcw.pojo;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Data
@Component
@PropertySource("classpath:application-dev-test.properties")
@ConfigurationProperties(prefix = "devtest")
public class ProSrouceConfig_User {
    private String name;

    private String age;

    private Integer id;




}
