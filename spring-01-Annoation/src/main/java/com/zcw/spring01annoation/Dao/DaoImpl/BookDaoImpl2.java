package com.zcw.spring01annoation.Dao.DaoImpl;

import com.zcw.spring01annoation.Dao.BookDao;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

/**
 * 因为与有Impl、Impl2
 *  按照类型注入就无法区分到底注入哪个对象，解决方案:按照名称注入
 *  先给两个Dao类分别起个名称
 */

@Repository("bookDao2")
public class BookDaoImpl2 implements BookDao {
    /**
     * 简单数据类型注入 (基本类型 和 字符串),从properties
     * 还要 在Config中配置
     */
    @Value("${name}")
    private String name;
    public void save() {
        System.out.println("BookDaoImpl save()...2 " + name);
    }
}