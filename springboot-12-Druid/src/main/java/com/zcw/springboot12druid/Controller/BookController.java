package com.zcw.springboot12druid.Controller;

import com.zcw.springboot12druid.Res.Code;
import com.zcw.springboot12druid.Res.Result;
import com.zcw.springboot12druid.Service.BookService;
import com.zcw.springboot12druid.pojo.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id) {
        Book book = bookService.getById(id);
        Integer code = book == null ? Code.GET_ERR : Code.GET_OK;
        String msg = book == null ? "数据查询失败，请重试！" : "";
        return new Result(book, code, msg);
    }

    @GetMapping("/all")
    public Result getAll() {
        List<Book> books = bookService.getAll();
        Integer code = books == null ? Code.GET_ERR : Code.GET_OK;
        String msg = books == null ? "数据查询失败，请重试！" : "";
        return new Result(books, code, msg);
    }

    @PostMapping
    public Result save(@RequestBody Book book) {
        boolean flag = bookService.save(book);
        String msg  = flag == false ? "save错误" : "save成功";
        Object data = "save";
        return new Result(data, flag ? Code.SAVE_OK : Code.SAVE_ERR, msg);
    }

    @PutMapping
    public Result update(@RequestBody Book book) {
        boolean flag = bookService.update(book);
        String msg = flag == false ? "update错误" : "update成功";
        return new Result(flag ? Code.UPDATE_OK : Code.UPDATE_ERR, msg);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        boolean delete = bookService.delete(id);
        String msg = delete == false ? "delete错误" : "delete成功";
        return new Result(delete ? Code.DELETE_OK : Code.DELETE_ERR, msg);
    }

}
