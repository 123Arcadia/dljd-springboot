package com.springboot08mybatis.dao;

import com.springboot08mybatis.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 1.
 * @Mapper:
 */
@Mapper
public interface UserDao {
    /**
     * 单个参数使用没意义，多个参数使用可以
     * @Param("user_id")
     */
//    @Param("user_id")
    User selectById(Integer id);


}
