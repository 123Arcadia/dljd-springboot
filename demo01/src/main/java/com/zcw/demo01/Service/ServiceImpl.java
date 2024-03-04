package com.zcw.demo01.Service;


import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.annotation.WebServlet;


//@Service("saveService")
@org.springframework.stereotype.Service("saveService")
public class ServiceImpl implements Service{


    @Override
    public void save() {

        System.out.println("sout : save()...");
    }
}
