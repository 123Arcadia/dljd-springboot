package com.zcw.springboot13mybatisplus.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zcw.springboot13mybatisplus.Dao.UserDao;
import com.zcw.springboot13mybatisplus.pojo.User;
import org.springframework.stereotype.Service;

@Service
public class IUserServiceImpl extends ServiceImpl<UserDao, User>  implements IUserService{

    @Override
    public boolean save(User entity) {
        System.out.println("save,,,");
        return true;
    }
}
