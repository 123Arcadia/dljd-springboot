package com.dljd.springbootdemo;

import com.dljd.User.MyStudent;
import com.dljd.User.Tiger;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootTest
class TestMy {

    @Test
    void contextLoads() {
    }

    @Test
    public void testBean() {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(config.class);
        MyStudent u= (MyStudent) ctx.getBean("createStu");
        System.out.println("u = " + u);
        // u = MyStudent{age=19, name='zcw', phone='123'}
    }

    @Test
    public void properties_test() {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(config.class);
        Tiger tiger = (Tiger) ctx.getBean("tiger01");
        System.out.println("tiger = " + tiger);
        // tiger = Tiger{name='"zcw"', age='10'}
    }

}
