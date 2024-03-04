package com.zcw.demomp;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zcw.demomp.Dao.UserDao;
import com.zcw.demomp.pojo.User;
import com.zcw.demomp.service.UserSerive;

import lombok.val;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@SpringBootTest
//@MapperScan(basePackages = "com.zcw.demomp")
class DemompApplicationTests {

    @Resource
    private UserDao userDao;

    @Test
    public void selectById() {
        List<User> users = userDao.selectList(null);
        System.out.println("users = " + users);
    }

    @Test
    public void and() {
        val queryWrapper = new LambdaQueryWrapper<User>();
//        queryWrapper.gt(User::getPhone, 14).lt(User::getPhone, 150);
        queryWrapper.like(User::getName, "郭%").and(i -> i.gt(User::getPhone, 14).lt(User::getPhone, 150));
        List<User> users = userDao.selectList(queryWrapper);
        System.out.println("users = " + users);
    }

    @Test
    public void nested() {
        LambdaQueryWrapper<User> q = new LambdaQueryWrapper<>();
        q.nested(i -> i.eq(User::getPhone, 15));
        List<Map<String, Object>> maps = userDao.selectMaps(q);
        System.out.println("maps = " + maps);
        //maps = [{password=abc123, address=HongKong, phone=15, name=郭富城}]
        User user = userDao.selectOne(q);
        System.out.println("user = " + user);
        //user = User(name=郭富城, password=abc123, phone=15, address=HongKong, version=null)
    }

    @Test
    public void limit() {
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        IPage<User> page = new Page<>(1, 3); //展示第一页，三条数据
        userDao.selectPage(page, null);
        System.out.println("当前页码" + page.getCurrent());
        System.out.println("本页条数" + page.getSize());
        System.out.println("总页数" + page.getPages());
        System.out.println("总条数" + page.getTotal());
        System.out.println(page.getRecords());
        //当前页码1
        //本页条数3
        //总页数2
        //总条数5
        //[User(name=章子怡, password=qwerty, phone=672, address=Beijing, version=null),
        // User(name=郭富城, password=abc123, phone=15, address=HongKong, version=null),
        // User(name=林志颖, password=654321, phone=186, address=Taiwan, version=null)]
    }

    @Test
    public void selectByName() {
        IPage<User> page = new Page<>(1, 2);
        userDao.selectByName(page, "郭富城");
        System.out.println("userIPage = " + page.getPages());
        List<User> users = page.getRecords();
        System.out.println("users = " + users);
    }

    /**
     * apply: 直接拼接在 WHERE 后
     */
    @Test
    public void apply() {
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.apply("id = 2 AND password = 'abc123'");
        User user = userDao.selectOne(queryWrapper);
        System.out.println("user = " + user);
    }

    /**
     * 内嵌逻辑查询func : 可以后面接子查询
     */
    @Test
    public void func() {
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.func(i->i.eq(User::getName,"郭富城"));
        System.out.println("userDao.selectOne(queryWrapper) = " + userDao.selectOne(queryWrapper));

    }

    @Test
    public void insert() {
        User user = userDao.selectById(5);
        user.setId(6);
        userDao.insert(user);

        User user1 = userDao.selectById(6);
        System.out.println("user1 = " + user1);
        //user1 = User(id=6, name=LadyGaGa, password=123456, phone=130, address=America, version=null)
    }
}
