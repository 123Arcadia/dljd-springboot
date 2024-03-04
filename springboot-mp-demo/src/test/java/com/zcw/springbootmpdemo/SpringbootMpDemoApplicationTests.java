package com.zcw.springbootmpdemo;

import com.zcw.springbootmpdemo.mybatisX.domain.User;
import com.zcw.springbootmpdemo.mybatisX.mapper.UserMapper;
import com.zcw.springbootmpdemo.mybatisX.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class SpringbootMpDemoApplicationTests {

    @Resource
    private UserMapper userMapper;
    @Test
    void contextLoads() {
    }

    @Test
    public void selectById() {
        User user = userMapper.selectById(2);
        System.out.println("user = " + user);
        //user = User(id=2, name=郭富城, password=abc123, address=HongKong, phone=15)
    }


    @Resource
    private UserService userService;
    @Test
    public void userServiceTest() {
        User user = userService.getById(2);
        System.out.println("user = " + user);
        //user = User(id=2, name=郭富城, password=abc123, address=HongKong, phone=15)
    }


    @Test
    public void selectByName() {
        User user = userMapper.selectByName("章子怡");
        System.out.println("user = " + user);
    }

}
