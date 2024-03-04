package com.springboot09mybatis.controller;

import com.springboot09mybatis.model.User;
import com.springboot09mybatis.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Controller
//@RestController
public class UserController {
    @Resource
    private UserService userService;

    @ResponseBody
    @RequestMapping("/query")
    public String queryUserById(Integer id) {
        User user = userService.queryUser(id);
        return user.toString();
    }
}
