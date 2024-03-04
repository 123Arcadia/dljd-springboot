package com.zcw.spring01annoation.Dao.DaoImpl;


import com.zcw.spring01annoation.Dao.BookDao;
import org.springframework.stereotype.Repository;

@Repository("bookDao")
public class BookDaoImpl implements BookDao {
    public void save() {
        System.out.println("BookDaoImpl save()...1");
    }
}
