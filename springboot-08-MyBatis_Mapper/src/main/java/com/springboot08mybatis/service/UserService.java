package com.springboot08mybatis.service;

import com.springboot08mybatis.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;

public interface UserService {
    User queryUser(Integer id);
}
