package com.zcw.demomp;

import com.zcw.demomp.Controller.UserController;
import com.zcw.demomp.EnumsEntity.GenderEnum;
import com.zcw.demomp.pojo.User;
import com.zcw.demomp.service.UserSerive;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import static com.baomidou.mybatisplus.core.toolkit.Wrappers.query;

@SpringBootTest
public class updateAllTest {
    @Resource
    private UserSerive userSerive;

    /**
     * 防止全表更新: 需要配置拦截器
     */
    @Test
    public void updateAll() {
        User user = new User();
        user.setGenderEnum(GenderEnum.MAN);
        //这里操作出错，因为防止全表更新（在config中）
//        userSerive.saveOrUpdate(user, null);
    }

    @Test
    public void query1() {
        System.out.println("userSerive.selectList() = " + userSerive.selectList());
        User user = userSerive.query().eq("name", "郭富城").one();

        System.out.println("user = " + user);
    }

    @Test
    public void query2() {
//        User user = query().eq("name", "郭富城").;
        System.out.println("userSerive.listMaps() = " + userSerive.listMaps());
        System.out.println("userSerive.query().eq(\"phone\", \"15\").getEntity() = " + userSerive.query().eq("phone", 15).one());

//        System.out.println("user = " + user);
    }
}
