package org.zcw1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.zcw1.confgig.SpringConfig1;
import org.zcw1.dao.BookDao;

public class App1 {
    /**
     * 调入参数 args[]
     * @param args
     */
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig1.class);
        BookDao bookDao = context.getBean(BookDao.class);
//        String name = bookDao.findName(9527);
        String name = bookDao.findName(9527, "Tony");
        System.out.println("name = " + name);
        //id:9527
        //TestName

        /**
         * args[] = 9527, "Tony"时
         */
        //args[] : [9527, Tony]
        //id:9527
        //name = TestName
    }
}
