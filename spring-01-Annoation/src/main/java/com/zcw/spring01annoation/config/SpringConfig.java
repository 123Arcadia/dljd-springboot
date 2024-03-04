package com.zcw.spring01annoation.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * componentScan扫描Dao和Service
 */
@Configuration
@ComponentScan({"com.zcw.spring01annoation.Dao", "com.zcw.spring01annoation.Service"})
@PropertySource("application.properties")
public class SpringConfig {
}