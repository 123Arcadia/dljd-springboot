package com.zcw.Controller;


import com.zcw.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")

public class UserController {
    @Autowired

    private User user;

    @GetMapping("/{id}")
    public User query(@PathVariable Integer id) {
        System.out.println("输入的id(和user.id无关) = " + id);
        System.out.println("user.getName() = " + user.getName());
        System.out.println("user.getAge() = " + user.getAge());
        System.out.println("user.getId() = " + user.getId());
        return user;
        //输入的id(和user.id无关) = 2
        //user.getName() = zhangchenwei
        //user.getAge() = 18
        //user.getId() = 999
    }
}
