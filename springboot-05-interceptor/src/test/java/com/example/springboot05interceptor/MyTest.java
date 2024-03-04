package com.example.springboot05interceptor;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

//@SpringBootTest
class MyTest {


    @Test
    public void test() {
        Map<String, String> map = new HashMap<>();
        map.put("1", "11");
        map.put("2", "22");
        map.put("3", null);
        if (map.get("3") == null) {
            System.out.println("null");
        } else {
            System.out.println("!null");
        }
    }

    @Test
    public void test01() {
        Date date = new Date();
        System.out.println("date.getTime() = " + date.getTime());
    }

    @Test
    public void test02() {
        boolean f = true;
        if (f == true) { // 优先
            System.out.println("true"); // true
        } else if (f) {
            System.out.println("==");
        }
        System.out.println("Double.MAX_VALUE = " + Double.MAX_VALUE); // Double.MAX_VALUE = 1.7976931348623157E308
    }

    public boolean zcw(int t) {
        if (t % 2 == 0) {
            return true;
        } else {
            return false;
        }
    }

    @Test
    public void test02_zcw() {
        zcw(3);

    }

    @Test
    public void test03() {
        System.out.println("9 / 2 = " + 9 / 2);
        System.out.println("9 / 2 = " + (double)9 /2);
//        9 / 2 = 4
//        9 / 2 = 4.5
    }

}
