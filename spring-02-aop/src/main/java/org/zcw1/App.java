package org.zcw1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.zcw1.dao.BookDao;
import org.zcw1.confgig.SpringConfig1;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig1.class);
        BookDao bookDao = context.getBean(BookDao.class);
        int select = bookDao.select();
        System.out.println("select = " + select);
        //around before advice ...
        //book dao select ...
        //around after advice ...
        //select = 100

//        bookDao.update();
        // before advice ...
        // BookDaoImpl update...


        /**
         * 可以看到 环绕通知 在最外层
         */
        //around before advice ...
        //before advice ...
        //BookDaoImpl update...
        //after advice ...
        //around after advice ...



    }


}