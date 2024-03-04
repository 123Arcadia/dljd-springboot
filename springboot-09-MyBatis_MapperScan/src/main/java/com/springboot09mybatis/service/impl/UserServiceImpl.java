package com.springboot09mybatis.service.impl;

import com.springboot09mybatis.service.UserService;
import com.springboot09mybatis.dao.UserDao;
import com.springboot09mybatis.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * 事务管理：@Transactional
 * 在springboot入口：加@EnableTransactionManagement
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;

    @Override
    public User queryUser(Integer id) {
        User user = userDao.selectById(id);
        return user;
    }
}
