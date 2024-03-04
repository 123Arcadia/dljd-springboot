package com.zcw.springannoationdemo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @ConfigurationProperties("**")：最好写在User1类上
 */
@Data
@Component
@AllArgsConstructor
@NoArgsConstructor
//@ConfigurationProperties("user1") // 最好写在User1类上
public class User1 {

    private String name;

    private String age;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
