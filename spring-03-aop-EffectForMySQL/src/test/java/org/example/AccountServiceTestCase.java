package org.example;

import org.example.Config.SpringConfig;
import org.example.Service.AccountService;
import org.example.domain.Account;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
public class AccountServiceTestCase {
    @Autowired
    private AccountService accountService;

    @Test
    public void testFindById(){
        Account account = accountService.findById(2);
        System.out.println("account = " + account);
        //业务层接口**次执行时间: 2164ms
        //accountList = null
    }

    @Test
    public void testFindAll(){
        List<Account> accountList = accountService.findAll();
        System.out.println("accountList = " + accountList);
        //业务层接口**次执行时间: 1243ms
        //account = null
    }


}