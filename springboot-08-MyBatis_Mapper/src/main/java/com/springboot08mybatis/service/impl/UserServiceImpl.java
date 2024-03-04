package com.springboot08mybatis.service.impl;

import com.springboot08mybatis.service.UserService;
import com.springboot08mybatis.dao.UserDao;
import com.springboot08mybatis.model.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;

    @Override
    public User queryUser(Integer id) {
        User user = userDao.selectById(id);
        return user;
    }
}
