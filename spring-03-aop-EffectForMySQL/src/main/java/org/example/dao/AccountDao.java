package org.example.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.example.domain.Account;

import java.util.List;

public interface AccountDao {

    @Select("select * from tbl_account")
    void selectAll();

    @Insert("insert into tbl_account(`name`,money) values(#{name},#{money}) ")
    void save(Account account);

    @Update("update tbl_account set `name`=#{name},money=#{money}")
    void update(Account account);

    @Select("select * from tbl_account")
    List<Account> findAll();

    @Select("select * from tbl_account where id=#{id}")
    Account findById(Integer id);

    @Delete("delete from tbl_account where id = #{id}")
    void delete(Integer id);
}