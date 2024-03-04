package org.zcw;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.zcw.config.SpringConfig;
import org.zcw.dao.BookDao;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        BookDao bookDao = context.getBean(BookDao.class);
//        bookDao.save();
        bookDao.update();
        // 1677083431774
        //BookDaoImpl save...
        //book dao update ...
        /**
         * 目前打印save方法的时候，因为方法中有打印系统时间，所以运行的时候是可以看到系统时间
         * 对于update方法来说，就没有该功能
         * 我们要使用SpringAOP的方式在不改变update方法的前提下让其具有打印系统时间的功能。
         */


    }
}