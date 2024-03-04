package com.zcw.springboot13mybatisplus.springTest13mp;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.zcw.springboot13mybatisplus.Dao.UserDao;
import com.zcw.springboot13mybatisplus.Service.IUserService;
import com.zcw.springboot13mybatisplus.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

/**
 * 来自spring_db数据库
 */
@SpringBootTest
public class test {

    @Resource
    private UserDao userDao;

    @Resource
    private IUserService userService;

    @Test
    public void testSelectById() {
        User user = userService.getById(2);
        System.out.println("user = " + user);
        //user = User{id=2, name='Jerry', password='jerry', age=4, tel='16688886666'}

        int count = userService.count();
        System.out.println("count = " + count); // 4
    }

    @Test
    public void list() {
        List<User> list = userService.list();
        System.out.println("list = " + list);
        //list = [User{id=1, name='user2修改', password='tom', age=3, tel='18866668888'},
        // User{id=2, name='Jerry', password='jerry', age=4, tel='16688886666'},
        // User{id=3, name='Jock', password='123456', age=41, tel='18812345678'},
        // User{id=4, name='略略略', password='nigger', age=15, tel='4006184000'}]
    }

    @Test
    public void like() {
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        //先后两次模糊查询，是类似链式查询
//        queryWrapper.like(User::getTel, 188); // 默认全模糊
        queryWrapper.likeRight(User::getTel, 166); // 右模糊
        List<User> list = userService.list(queryWrapper);
        System.out.println("list = " + list);
        //list = [User{id=1, name='user2修改', password='tom', age=3, tel='18866668888'},
        // User{id=3, name='Jock', password='123456', age=41, tel='18812345678'}]

        //list = []
    }
}
