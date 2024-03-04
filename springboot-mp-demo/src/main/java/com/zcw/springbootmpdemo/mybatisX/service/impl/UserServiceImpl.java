package com.zcw.springbootmpdemo.mybatisX.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zcw.springbootmpdemo.mybatisX.service.UserService;
import com.zcw.springbootmpdemo.mybatisX.domain.User;
import com.zcw.springbootmpdemo.mybatisX.mapper.UserMapper;
import org.springframework.stereotype.Service;

/**
* @author zhangchenwei
* @description 针对表【user】的数据库操作Service实现
* @createDate 2023-04-12 10:48:39
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
implements UserService {


}
