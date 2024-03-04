package com.zcw.springboot12druid.Service;

import com.zcw.springboot12druid.pojo.Book;

import java.util.List;

public interface BookService {
    boolean save(Book book);

    boolean update(Book book);

    boolean delete(Integer book);

    Book getById(Integer id);

    List<Book> getAll();
}
