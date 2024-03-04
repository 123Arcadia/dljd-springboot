package com.zcw.demomp;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.toolkit.SimpleQuery;
import com.zcw.demomp.pojo.User;
import lombok.experimental.StandardException;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@SpringBootTest
public class SimpleQueryTest {

    @Test
    public void list() {
        List<Object> list = SimpleQuery.list(new LambdaQueryWrapper<User>().eq(User::getName, "郭富城"), User::getId);
        System.out.println("list = " + list);
        //list = [2]
    }

    @Test
    public void list1() {
        List<Object> list = SimpleQuery.list(new LambdaQueryWrapper<User>().eq(User::getName, "LadyGaGa"), User::getName, e ->
                Optional.of(e.getName()).map(String::toLowerCase).ifPresent(e::setName));
        System.out.println("list = " + list);
        //list = [ladygaga]
    }

    /**
     * 以 [id - 实体类] 封装为Map集合
     */
    @Test
    public void Map() {
        Map<Integer, User> map = SimpleQuery.keyMap(new LambdaQueryWrapper<User>(), User::getId);
        System.out.println("map = " + map);
        //map = {1=User(id=1, name=章子怡, password=qwerty, phone=672, address=Beijing, version=null),
        // 2=User(id=2, name=郭富城, password=abc123, phone=15, address=HongKong, version=null),
        // 3=User(id=3, name=林志颖, password=654321, phone=186, address=Taiwan, version=null),
        // 4=User(id=4, name=梁静茹, password=987654367, phone=1, address=malaixiya, version=null),
        // 5=User(id=5, name=LadyGaGa, password=123456, phone=130, address=America, version=null)}
    }

    /**
     * 以 [自定 - 自定] 封装为Map集合
     */
    @Test
    public void KeyMap() {
        Map<Integer, String> map = SimpleQuery.map(new LambdaQueryWrapper<User>(), User::getId, User::getName);
        System.out.println("map = " + map);
        //map = {1=章子怡, 2=郭富城, 3=林志颖, 4=梁静茹, 5=LadyGaGa}
    }

    /**
     * 分组查询
     */
    @Test
    public void group() {
        Map<String, List<User>> map = SimpleQuery.group(new LambdaQueryWrapper<User>(), User::getName);
        System.out.println("map = " + map);
        //map = {郭富城=[User(id=2, name=郭富城, password=abc123, phone=15, address=HongKong, version=null)],
        // 林志颖=[User(id=3, name=林志颖, password=654321, phone=186, address=Taiwan, version=null)],
        // 章子怡=[User(id=1, name=章子怡, password=qwerty, phone=672, address=Beijing, version=null)],
        // 梁静茹=[User(id=4, name=梁静茹, password=987654367, phone=1, address=malaixiya, version=null)],
        // LadyGaGa=[       User(id=5, name=LadyGaGa, password=123456, phone=130, address=America, version=null),
        //                  User(id=6, name=LadyGaGa, password=123456, phone=130, address=America, version=null)     ]}
    }

}

