package org.zcw.dao.impl;

import org.springframework.stereotype.Repository;
import org.zcw.dao.BookDao;

@Repository
public class BookDaoImpl implements BookDao {

    public void save() {
        System.out.println(System.currentTimeMillis());
        System.out.println("BookDaoImpl save...");
    }

    public void update() {
        System.out.println("book dao update ...");
    }
}
