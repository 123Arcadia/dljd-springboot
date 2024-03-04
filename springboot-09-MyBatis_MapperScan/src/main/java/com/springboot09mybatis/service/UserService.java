package com.springboot09mybatis.service;

import com.springboot09mybatis.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;

public interface UserService {
    User queryUser(Integer id);
}
