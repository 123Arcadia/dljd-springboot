package com.zcw.springbootmpdemo.mybatisX.Controller;

import com.zcw.springbootmpdemo.mybatisX.service.UserService;
import com.zcw.springbootmpdemo.mybatisX.domain.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class UserController {
    @Resource
    private UserService userService;

    @ResponseBody
    @RequestMapping("/query")
    public String queryUserById(Integer id) {
        User user = userService.getById(id);
        return user.toString();
    }
}
