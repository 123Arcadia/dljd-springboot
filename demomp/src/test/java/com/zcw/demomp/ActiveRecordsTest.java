package com.zcw.demomp;

import com.zcw.demomp.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * 继承了Model类
 */
@SpringBootTest
public class ActiveRecordsTest {

    /**
     * crud操作都可以
     */
    @Test
    public void select() {
        User user = new User();
        user.setId(1);
        System.out.println("user.selectById() = " + user.selectById());
    }
}
