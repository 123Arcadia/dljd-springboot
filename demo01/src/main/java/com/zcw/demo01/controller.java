package com.zcw.demo01;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class controller {
    @RequestMapping("/demo01")
    @ResponseBody
    public void test() {
        System.out.println("zcw");
    }
}
