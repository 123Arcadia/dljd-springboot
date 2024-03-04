package com.zcw.demomp.Controller;

import com.zcw.demomp.pojo.User;
import com.zcw.demomp.service.UserSerive;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class UserController {

    @Resource
    private UserSerive userSerive;

    @RequestMapping("userList")
    public List<User> selectList() {
        return userSerive.selectList();
    }
}
