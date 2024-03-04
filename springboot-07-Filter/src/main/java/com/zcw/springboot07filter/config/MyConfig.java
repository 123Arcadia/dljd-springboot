package com.zcw.springboot07filter.config;

import com.zcw.springboot07filter.web.MyFilter;
import com.zcw.springboot07filter.web.MyFilter2;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.ArrayList;
import java.util.Arrays;

@Configuration
public class MyConfig {
    @Bean
    public FilterRegistrationBean filterRegistrationBean() {
        FilterRegistrationBean bean = new FilterRegistrationBean<>();
        bean.setFilter(new MyFilter());
        bean.addUrlPatterns("/user/*");
//        bean.setUrlPatterns(new ArrayList<>(Arrays.asList("/api/*")));
        return bean;
    }

    @Bean
    public FilterRegistrationBean filterRegistrationBean2() {
        FilterRegistrationBean<Filter> bean = new FilterRegistrationBean<>();
        bean.setFilter(new MyFilter2());
        bean.addUrlPatterns("/user/*");
        return bean;
    }
}
