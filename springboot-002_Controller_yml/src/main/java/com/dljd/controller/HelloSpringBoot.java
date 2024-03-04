package com.dljd.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloSpringBoot {
    @RequestMapping("/hello")
    @ResponseBody
    public String helloSpringBoot() {
        return "欢迎使用SpringBoot!";
    }


    @Value("${server.port}")
    private String port;
    @Value("${server.servlet.context-path}")
    private String contextPath;
    @Value("${school.name}")
    private String school_name;
    @Value("${school.website}")
    private String school_website;
    @Value("${site}")
    private String site;

    @RequestMapping("/pros")
    @ResponseBody
    public String queryProsInfo() {
        return "HelloSpringBoot{" +
                "port='" + port + '\'' +
                ", contextPath='" + contextPath + '\'' +
                ", school_name='" + school_name + '\'' +
                ", school_website='" + school_website + '\'' +
                ", site='" + site + '\'' +
                '}';
    }

    @RequestMapping("/school")
    @ResponseBody
    public String queryProsSchoolInfo() {
        return "HelloSpringBoot{" +
                "school_name='" + school_name + '\'' +
                ", school_website='" + school_website + '\'' +
                '}';
    }
}
