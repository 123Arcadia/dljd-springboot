package com.zcw.springbootmpdemo.mybatisX.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zcw.springbootmpdemo.mybatisX.domain.User;
import org.apache.ibatis.annotations.Mapper;

/**
* @author zhangchenwei
* @description 针对表【user】的数据库操作Mapper
* @createDate 2023-04-12 10:48:39
* @Entity mybatisX.domain.User
*/
@Mapper
public interface UserMapper extends BaseMapper<User> {
    User selectByName(String name);

}
