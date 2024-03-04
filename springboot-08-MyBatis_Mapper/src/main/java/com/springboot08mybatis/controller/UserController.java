package com.springboot08mybatis.controller;

import com.springboot08mybatis.model.User;
import com.springboot08mybatis.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
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
