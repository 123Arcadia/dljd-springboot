package com.zcw.springboot12druid.Service;

import com.zcw.springboot12druid.Dao.BookDao;
import com.zcw.springboot12druid.Exception.BusinessException;
import com.zcw.springboot12druid.Exception.SystemException;
import com.zcw.springboot12druid.Res.Code;
import com.zcw.springboot12druid.pojo.Book;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {


    @Autowired
    private BookDao bookDao;

    @Override
    public boolean save(Book book) {
        int save = bookDao.save(book);
        System.out.println("save success!");
        return save > 0;
    }

    @Override
    public boolean update(Book book) {
        int update = bookDao.update(book);
        System.out.println("update success!");
        return update > 0;
    }

    @Override
    public boolean delete(Integer id) {
        System.out.println("delete success!");
        return bookDao.delete(id) > 0;
    }

    @Override
    public Book getById(Integer id) {
        System.out.println("getById success!");
        if (id == 1) {
            throw new BusinessException(Code.BUSINESS_ERR, "id == 1 不能看");
        }


        try {
            int n = 1 / 0;
        } catch (Exception e) {
            throw new SystemException(Code.SYSTEM_UNKNOW_ERR, "未知错误");
        }
        return bookDao.getById(id);
    }

    @Override
    public List<Book> getAll() {
        System.out.println("getAll success!");
        return bookDao.getAll();
    }
}
