package com.zcw.springboot13mybatisplus;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zcw.springboot13mybatisplus.Dao.UserDao;
import com.zcw.springboot13mybatisplus.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;


@SpringBootTest
class Springboot13MyBatisPlusApplicationTests {
    @Autowired
    private UserDao userDao;

    @Test
    void selectById() {
        User user = userDao.selectById(1);
        System.out.println("user = " + user);
        //user = User{id=1, name='Tom', password='tom', age=3, tel='18866668888'}
    }

    @Test
    public void selectAll() {
        List<User> users = userDao.selectList(null);
        for (User user : users) {
            System.out.print(user + "->");
        }
        //User{id=1, name='Tom', password='tom', age=3, tel='18866668888'}->
        // User{id=2, name='Jerry', password='jerry', age=4, tel='16688886666'}->
        // User{id=3, name='Jock', password='123456', age=41, tel='18812345678'}->
        // User{id=4, name='略略略', password='nigger', age=15, tel='4006184000'}->
    }

    @Test
    public void selectCount() {
        Integer count = userDao.selectCount(null);
        System.out.println("count = " + count);
        //count = 4
    }

    @Test
    public void selectMaps() {
        List<Map<String, Object>> maps = userDao.selectMaps(null);
        for (Map<String, Object> map : maps) {
            System.out.println(map);
            System.out.println(map.keySet());
            System.out.println(map.values());
            System.out.println("--------------");
        }
        //{password=tom, name=Tom, tel=18866668888, id=1, age=3}
        //[password, name, tel, id, age]
        //[tom, Tom, 18866668888, 1, 3]
        //--------------
        //{password=jerry, name=Jerry, tel=16688886666, id=2, age=4}
        //[password, name, tel, id, age]
        //[jerry, Jerry, 16688886666, 2, 4]
        //--------------
        //{password=123456, name=Jock, tel=18812345678, id=3, age=41}
        //[password, name, tel, id, age]
        //[123456, Jock, 18812345678, 3, 41]
        //--------------
        //{password=nigger, name=略略略, tel=4006184000, id=4, age=15}
        //[password, name, tel, id, age]
        //[nigger, 略略略, 4006184000, 4, 15]
        //--------------
    }

    /**
     * 报错
     */
    @Test
    public void selectOne() {
//        User user = userDao.selectOne(1);
//        System.out.println("user = " + user);
    }

    @Test
    public void testSelectPage() {
        IPage<User> page = new Page<>(1, 3);
        userDao.selectPage(page, null);
        System.out.println("当前页码" + page.getCurrent());
        System.out.println("本页条数" + page.getSize());
        System.out.println("总页数" + page.getPages());
        System.out.println("总条数" + page.getTotal());
        System.out.println(page.getRecords());
        //当前页码1
        //本页条数3
        //总页数0
        //总条数0
        //[User{id=1, name='Tom', password='tom', age=3, tel='18866668888'},
        // User{id=2, name='Jerry', password='jerry', age=4, tel='16688886666'},
        // User{id=3, name='Jock', password='123456', age=41, tel='18812345678'},
        // User{id=4, name='略略略', password='nigger', age=15, tel='4006184000'}]
    }

    /**
     * 批量查询
     */
    @Test
    public void testSelectBatchIds() {
        Collection<Integer> collections = new ArrayList<>();
        collections.add(1);
        collections.add(4);
        List<User> userList = userDao.selectBatchIds(collections);
        System.out.println("userList = " + userList);
        // userList = [User{id=1, name='Tom', password='tom', age=3,
        // tel='18866668888'}, User{id=4, name='略略略', password='nigger',
        // age=15, tel='4006184000'}]

    }

    @Test
    public void testSelectByMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("name", "Tom");
        map.put("name", "略略略");
        List<User> maps = userDao.selectByMap(map);
        System.out.println("maps = " + maps);
        //maps = [User{id=4, name='略略略', password='nigger', age=15, tel='4006184000'}]
    }

    /**
     * 条件查询
     */
    @Test
    public void test_QueryWrapper() {
        LambdaQueryWrapper<User> lqw = new LambdaQueryWrapper<>();
        lqw.lt(User::getAge, 30).gt(User::getAge, 0);
        List<User> users = userDao.selectList(lqw);
        System.out.println("users = " + users);
        //users = [User{id=1, name='Tom', password='tom', age=3, tel='18866668888'},
        // User{id=2, name='Jerry', password='jerry', age=4, tel='16688886666'},
        // User{id=4, name='略略略', password='nigger', age=15, tel='4006184000'}]
    }

    /**
     * 乐观锁：
     *      只修改一次，version = version + 1
     */
    @Test
    public void test_OptimisticLock() {
        //1. 先通过要修改的数据id将当前数据查询出来
        User user = userDao.selectById(1L);
        //2. 修改属性
        user.setName("OptimisticLock");
        userDao.updateById(user);
    }

    /**
     * 乐观锁：
     *      多个人修改，version =
     */
    @Test
    public void test_OptimisticLock_MultiPersons() {
        //1. 先通过要修改的数据id将当前数据查询出来
        // 第一次是version = 1
        User user1 = userDao.selectById(1L); // version = 1
        User user2 = userDao.selectById(1L); // version = 1
        user2.setName("user2修改");

        userDao.updateById(user2); // user2修改后，version = 2

        user1.setName("user1修改");
        //A拿到的version是1，但现在的version已经是2了，
        // 那么A在执行 UPDATE ... WHERE version = 1时，就必然会失败
        userDao.updateById(user1);

        // 结果：显示user2修改，user1修改没有成功
    }

}
