package com.dljd.springboot003multi_dev_pros.controler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BootController {
    @RequestMapping("/test01")
    @ResponseBody
    public String doSome() {
        return "多环境配置！";
    }

}
