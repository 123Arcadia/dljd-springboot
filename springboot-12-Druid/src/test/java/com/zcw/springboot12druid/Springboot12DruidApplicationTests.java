package com.zcw.springboot12druid;

import com.zcw.springboot12druid.Dao.BookDao;
import com.zcw.springboot12druid.pojo.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class Springboot12DruidApplicationTests {
    @Autowired
    private BookDao bookDao;
    @Test
    void contextLoads() {
        List<Book> all = bookDao.getAll();
        System.out.println("all = " + all);
    }

}
