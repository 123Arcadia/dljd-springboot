package org.baiDuWangPan.Service.Impl;

import org.baiDuWangPan.Resource.ResourceDao;
import org.baiDuWangPan.Service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResourceServiceImpl implements ResourceService {
    @Autowired
    private ResourceDao resourceDao;
    public boolean openURL(String url, String password) {
        System.out.println("password = " + password);
        return resourceDao.readResource(url,password);
    }
}