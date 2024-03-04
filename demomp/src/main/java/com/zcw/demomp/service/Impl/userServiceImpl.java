package com.zcw.demomp.service.Impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zcw.demomp.Dao.UserDao;
import com.zcw.demomp.pojo.User;
import com.zcw.demomp.service.UserSerive;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

@Service
public class userServiceImpl extends  ServiceImpl<UserDao, User> implements UserSerive  {
    @Autowired
    private UserDao userDao;

    @Override
    public List<User> selectList() {
        return userDao.selectList(null);
    }

}
