package com.zcw.demomp;

import com.zcw.demomp.Dao.UserDao;
import com.zcw.demomp.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
public class TableLogicTest {


    @Resource
    private UserDao userDao;

    @Test
    public void insert() {
        User user = userDao.selectById(6);
        user.setId(7);
        userDao.insert(user);
    }


    /**
     * 逻辑删除
     */
    @Test
    public void Logic() {
        int i = userDao.deleteById(7);
        System.out.println("i = " + i);
        //UPDATE user SET status=0 WHERE id=? AND status=1
    }

    /**
     * 在逻辑删除后没有显示id = 7，但数据status = 0
     */
    @Test
    public void selectList() {
        List<User> list = userDao.selectList(null);
        System.out.println("list = " + list);
        //list = [User(id=1, name=章子怡, password=qwerty, phone=672, address=Beijing, status=1, version=null),
        // User(id=2, name=郭富城, password=abc123, phone=15, address=HongKong, status=1, version=null),
        // User(id=3, name=林志颖, password=654321, phone=186, address=Taiwan, status=1, version=null),
        // User(id=4, name=梁静茹, password=987654367, phone=1, address=malaixiya, status=1, version=null),
        // User(id=5, name=LadyGaGa, password=123456, phone=130, address=America, status=1, version=null),
        // User(id=6, name=LadyGaGa, password=123456, phone=130, address=America, status=1, version=null)]
    }
}
