package com.example.springboot05interceptor.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BootController {
    @RequestMapping("/user/Account")
    @ResponseBody
    public String userAccount() {
        return "访问/user/Account";
    }

    @RequestMapping("/user/login")
    @ResponseBody
    public String userLogin() {
        return "访问/user/login";
    }
}
