package com.zcw.spring01annoation;

import com.zcw.spring01annoation.Dao.BookService;
import com.zcw.spring01annoation.config.SpringConfig;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);
        BookService bookService = ctx.getBean(BookService.class);
        bookService.save();
        // BookService save()...
        // BookDaoImpl save()...

        // 有两个Dao1、Dao2, 在BookServiceImpl2中自动装配@Autowired会按名称装配
        // BookService save()...
        // BookDaoImpl save()...1

        // 简单数据类型注入
        // BookService save()...
        // BookDaoImpl save()...2 zcw

    }


}
