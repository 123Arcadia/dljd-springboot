package com.zcw.springannoationdemo;

import com.zcw.springannoationdemo.config.SpringConfig;
import com.zcw.springannoationdemo.pojo.User1;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@SpringBootTest
public class SpringAnnoationDemoApplicationTests {

    @Autowired
    @Qualifier("cc")
    private User1 user;

    @Autowired
    @Qualifier("create_user")
    private User1 user1;
//    public static void main(String[] args) {
//        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);
//
//    }

    /**
     * properties的变量优先
     */
    @Test
	public void test_create_user() {
		System.out.println("user = " + user);
		System.out.println("user = " + user.getName());
		System.out.println("user = " + user.getAge());
		//user = User1(name=zcw, age=999_pro)
        //user = zcw
        //user = 999_pro
	}

    /**
     * properties的变量优先
     * 在@Bean("cc")中成功,
     *          @ConfigurationProperties(prefix = "user1")
     */
    @Test
    public void test_cc_user1() {
        System.out.println("user = " + user);
        System.out.println("user = " + user.getName());
        System.out.println("user = " + user.getAge());
//        user = User1(name=zcw, age=999_pro)
//        user = zcw
//        user = 999_pro
    }

    /**
     * 关注 @Qualifier("user1") 还是@Qualifier("create_user")
     */
    @Test
    public void test02() {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);
        User1 create_user1 = (User1) ctx.getBean("create_user");
        System.out.println("create_user1 = " + create_user1);
        //create_user1 = User1(name=create_user, age=10)
    }

    @Test
    public void test_cc_01() {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);
        User1 cc_01 = ctx.getBean("cc_01", User1.class);
        System.out.println("cc_01 = " + cc_01);
        // cc_01 = User1(name=ccc, age=555cccc)
    }

}
