package com.zcw.demomp;

import com.zcw.demomp.Dao.UserDao;
import com.zcw.demomp.EnumsEntity.GenderEnum;
import com.zcw.demomp.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.HashMap;

@SpringBootTest
public class FastJson {
    @Resource
    private UserDao userDao;

    @Test
    public void typeHandler() {
        User user = new User();
        user.setId(9);
        user.setName("json");
        user.setPhone("1111111");
        user.setAddress("jsonAddress");
        user.setGenderEnum(GenderEnum.WOMAN);
        user.setStatus(1);
        user.setPassword("passW");
        HashMap<String, String> map = new HashMap<>();
        map.put("tel", "json-Tel");
        map.put("Address", "json-Address");
        user.setConcat(map);
        userDao.insert(user);
        //{"Address":"json-Address","tel":"json-Tel"}
    }
}
