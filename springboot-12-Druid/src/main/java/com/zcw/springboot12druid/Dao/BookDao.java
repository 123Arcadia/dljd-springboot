package com.zcw.springboot12druid.Dao;

import com.zcw.springboot12druid.pojo.Book;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BookDao {
    @Select("select * from spring_db.tbl_book where id=#{id}")
    Book getById(Integer id);

    @Select("select * from spring_db.tbl_book")
    List<Book> getAll();

    @Update("update spring_db.tbl_book set type = #{type} , `name`=#{name}, `description`=#{description} where id=#{id} ")
    int update(Book book);

    @Delete("delete from spring_db.tbl_book where id=#{id}")
    int delete(Integer id);

    @Insert("insert into spring_db.tbl_book values (null, #{type}, #{name}, #{description})")
    int save(Book book);

}
