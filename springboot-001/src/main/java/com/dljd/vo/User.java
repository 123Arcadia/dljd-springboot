package com.dljd.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;



@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private String name;
    private String age;
}
