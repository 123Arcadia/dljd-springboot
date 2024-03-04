package org.zcw1.dao.impl;

import org.springframework.stereotype.Repository;
import org.zcw1.dao.BookDao;

@Repository
public class BookDaoImpl implements BookDao {

    public void update() {
        System.out.println("BookDaoImpl update...");
    }

    public int select() {
        System.out.println("book dao select ...");
        int s = 1 / 0;
        return 100;
    }

    /**
     * 环绕通知获取返回值
     * @param id
     * @return
     */
    public String findName(int id) {
        System.out.println("id:" + id);
        return "TestName";
    }

    public String findName(int id, String name) {
        System.out.println("id:" + id);
        return "TestName";
    }
}
