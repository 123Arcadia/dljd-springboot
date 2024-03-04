package com.zcw.springannoationdemo.TestDemo;


import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.util.StringUtils;

import javax.validation.Valid;

import static org.apache.logging.log4j.util.Strings.isBlank;


@Slf4j
public class Test01 {
    @Test
    public void Data() {
        User user = new User();
        user.setAge("19");
        user.setName("zcw");
        user.setNumber(28);
        user.Number = 30;
        System.out.println("user = " + user);

        User zcw = new User("zcw", "16", 28);
        System.out.println(zcw);

        //user = User(Name=zcw, Age=19)
        //User(Name=zcw, Age=16)
        if (user.canEqual(zcw)) {
            System.out.println("==");
        } else {
            System.out.println("!=");
        }
        // ==

        if (user.Age.equals(zcw.getAge())) {
            System.out.println("==");
        } else {
            System.out.println("!=");
        }
        //!=
    }

    @Test
    public void test_Valid() {
        User user = new User("zcw", "17", -1);
        test(user, -2);
        System.out.println("user = " + user.Number);
        //user = -2
    }

    public void test(User user, @Valid Integer number) {
        user.Number = number;
    }

    @Test
    public void test_String_isEmpty_isBlank() {
        String a = "zcw";
        String b = "z cw";
        String c;
        String d = " ";
        System.out.println(a.isEmpty()); // false
        System.out.println(StringUtils.isEmpty(d)); // false
        // 被弃用
//        自5.3版本起，isEmpty(Object)已建议弃用，使用hasLength(String)或hasText(String)替代。
        System.out.println("d.length = " + d.length()); // 1
        System.out.println(StringUtils.hasLength(d)); // true
        System.out.println(StringUtils.hasText(d)); // false

        /**
         * 来自StringUtils和Strings的isBlank()都会判断空格是否存在，都一样!!!
         */
        /**
         * import static org.apache.commons.lang.StringUtils.isBlank;
         */
        System.out.println(isBlank(d)); // true

        /**
         * import static org.apache.logging.log4j.util.Strings.isBlank;
         */
        System.out.println(isBlank(d)); // true
    }
}
