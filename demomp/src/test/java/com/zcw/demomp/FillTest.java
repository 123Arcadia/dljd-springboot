package com.zcw.demomp;

import com.zcw.demomp.Dao.UserDao;
import com.zcw.demomp.EnumsEntity.GenderEnum;
import com.zcw.demomp.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.HashMap;

@SpringBootTest
public class FillTest {
    @Resource
    private UserDao userDao;

    @Test
    public void Fill_Insert() {
        User user = new User();
//        user.setId(11);
        user.setName("json_Insert");
        user.setPhone("22222");
        user.setAddress("jsonAddress");
        user.setGenderEnum(GenderEnum.WOMAN);
        user.setStatus(1);
        user.setPassword("passWord");
        HashMap<String, String> map = new HashMap<>();
        map.put("tel", "json-Tel2222");
        map.put("Address", "json-Address2222");
        user.setConcat(map);
        userDao.insert(user);
    }

    @Test
    public void Fill_Insert_Update() {
        User user = new User();
//        user.setId(9);
        user.setName("json_Fill_Insert_Update");
        user.setPhone("33333");
        user.setAddress("jsonAddress");
        user.setGenderEnum(GenderEnum.WOMAN);
        user.setStatus(1);
        user.setPassword("passWord");
        HashMap<String, String> map = new HashMap<>();
        map.put("tel", "33json-Tel3333");
        map.put("Address", "33json-Address3333");
        user.setConcat(map);
        userDao.updateById(user);
    }
}
