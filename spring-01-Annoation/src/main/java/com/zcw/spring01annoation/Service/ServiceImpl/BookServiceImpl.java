package com.zcw.spring01annoation.Service.ServiceImpl;

import com.zcw.spring01annoation.Dao.BookDao;
import com.zcw.spring01annoation.Dao.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    @Qualifier("bookDao2") // 重置BeanId
    private BookDao bookDao;

//    public void setBookDao(BookDao bookDao) {
//        this.bookDao = bookDao;
//    }

    public void save() {
        System.out.println("BookService save()...");
        bookDao.save();
    }
}
