package com.example.springboot03multi_env.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
@Controller
public class BootController {
    @ResponseBody
    @RequestMapping("/test")
    public String doSome() {
        return "多环境配置!";
    }
}
