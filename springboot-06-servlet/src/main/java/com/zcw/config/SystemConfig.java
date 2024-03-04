package com.zcw.config;

import com.zcw.springboot06servlet.MyServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 2. 注册 Servlet
 */
@Configuration
public class SystemConfig {
    @Bean
    public ServletRegistrationBean servletRegistrationBean() {
        /**
         * 第一种方法：
         */
//        ServletRegistrationBean reg = new ServletRegistrationBean(new MyServlet(), "/loginServlet");
        /**
         * 第二种方法：
         */
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean();
        servletRegistrationBean.setServlet(new MyServlet());
        servletRegistrationBean.addUrlMappings("/test01", "/test02");
        return servletRegistrationBean;
    }
}
