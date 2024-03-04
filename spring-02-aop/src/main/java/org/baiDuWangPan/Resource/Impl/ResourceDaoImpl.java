package org.baiDuWangPan.Resource.Impl;

import org.baiDuWangPan.Resource.ResourceDao;
import org.springframework.stereotype.Repository;

@Repository
public class ResourceDaoImpl implements ResourceDao {
    public boolean readResource(String url, String password) {
        //模拟校验
        return password.equals("root");
    }
}
