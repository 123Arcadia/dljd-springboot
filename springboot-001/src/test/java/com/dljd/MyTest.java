package com.dljd;

import com.dljd.config.SpringConfig;
import com.dljd.vo.Cat;
import com.dljd.vo.Student;
import com.dljd.vo.Tiger;
//import org.junit.Test;
import com.dljd.vo.User;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    /**
     * 使用xml做容器配置文件
     */
    @Test
    public  void test01() {
        String config="beans.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(config);
//        Student student = (Student) ctx.getBean("myStudent");
//        Student student = ctx.getBean("myStudent", Student.class);
        Student student = ctx.getBean(Student.class);
        System.out.println("student = " + student);
        // student = Student{name='李思', age=20, sex='女'}
    }

    // 注意和为导入 xml 的方法对比
    @Test
    public  void test01_1() {
//        String config="beans.xml";
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);
        Student student = (Student) ctx.getBean("myStudent");
        System.out.println("student = " + student);
        // student = Student{name='李思', age=20, sex='女'}
    }

    /**
     * 使用javaConfig
     */
    @Test
    public void test02() {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);
        Student student = (Student) ctx.getBean("createStudent");
        System.out.println("使用javaConfig:createStudent = " + student);
//        使用javaConfig:createStudent = Student{name='张三', age=26, sex='男'}
    }

    /**
     * 另一种Bean命名
     */
    @Test
    public void test_Cat0() {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);
        Student student = (Student) ctx.getBean("stu_01");
        System.out.println("使用javaConfig:stu = " + student);
        // 使用javaConfig:stu = Student{name='stu_01', age=26, sex='女'}
    }

    @Test
    public void test_Cat1() {
        /**
         * 来自: applicationContext.xml中设置 Bean
         */
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);
        Cat cat = (Cat) ctx.getBean("myCat");
        System.out.println("cat = " + cat);
        // cat = Cat{name='tom猫', cardId='uw2333', age=2}
    }

    /**
     * 导入properties
     */
    @Test
    public void test_tiger_properties() {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);
        Tiger tiger = (Tiger) ctx.getBean("tiger");
        System.out.println("tiger = " + tiger);
        // tiger = Tiger{name='zcw', age=16}
    }

    @Test
    public void test_cc_user() {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);
        User user = ctx.getBean(User.class);
        System.out.println("user = " + user);
        // user = User(name=zzzz, age=111)
    }

    @Test
    public void toBinaryString() {
        double l= 3.3;
        double r= 3.6;
        int c = (int) l;
        int d = (int) r;
        System.out.println("c = " + c); // 3
        System.out.println("d = " + d); // 3
        System.out.println(Math.ceil(l));
        System.out.println(Math.floor(l));
        System.out.println((2 + 3) / 2); // 2



    }



}
