package com.springboot09mybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
//@MapperScan(basePackages = "com.springboot09mybatis.dao")
@MapperScan(value = "com.springboot09mybatis.dao")
public class Springboot09MyBatisApplication {
    public static void main(String[] args) {
        SpringApplication.run(Springboot09MyBatisApplication.class, args);
    }
}
