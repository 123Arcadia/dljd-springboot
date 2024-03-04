package com.zcw.demomp.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zcw.demomp.pojo.User;

import java.util.List;

public interface UserSerive extends IService<User>{

    List<User> selectList();
}
