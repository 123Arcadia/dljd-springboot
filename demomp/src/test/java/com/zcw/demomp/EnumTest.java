package com.zcw.demomp;

import com.zcw.demomp.Dao.UserDao;
import com.zcw.demomp.EnumsEntity.GenderEnum;
import com.zcw.demomp.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

@SpringBootTest
public class EnumTest {
    @Resource
    private UserDao userDao;


    @Test
    public void selectList() {
        List<User> list = userDao.selectList(null);
        System.out.println("list = " + list);
    }

    @Test
    public void enumTest() {
        User user = new User();
        user.setId(8);
        user.setName("enumTotestMAN");
        user.setPhone("8888888");
        user.setAddress("adressT");
        user.setGenderEnum(GenderEnum.MAN);
        user.setStatus(1);
        user.setPassword("zzzz");
        user.setConcat(null);
        userDao.insert(user);
        System.out.println("userDao.selectById(8) = " + userDao.selectById(8));
        //userDao.selectById(8) =
        // User(id=8, name=enumTotestMAN, password=zzzz, phone=8888888, address=adressT, status=1, genderEnum=MAN, version=null)
    }
}
