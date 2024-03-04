package com.dljd.springboot04userservice;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Override
    public void doSerive(String name) {
        System.out.println("doService : name = " + name);
    }

    public UserServiceImpl() {
        System.out.println("construct ... ");
    }

    public void save() {
        System.out.println("UserServiceImpl save ...");
    }
    @PostConstruct
    public void init() {
        System.out.println("init ... ");
    }
    @PreDestroy
    public void destroy() {
        System.out.println("destroy ... ");
    }


}
