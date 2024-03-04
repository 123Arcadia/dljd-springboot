package com.zcw.springboot07filter.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {
    @RequestMapping("/user/account")
    @ResponseBody
    public String hello(){
        return "/user/account";
    }

    @RequestMapping("/query")
    @ResponseBody
    public String doSome() {
        return "/query";
    }
}
