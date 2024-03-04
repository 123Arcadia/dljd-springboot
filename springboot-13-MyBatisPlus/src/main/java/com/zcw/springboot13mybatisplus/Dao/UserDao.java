package com.zcw.springboot13mybatisplus.Dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zcw.springboot13mybatisplus.pojo.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao extends BaseMapper<User> {
}
/**
 * 配置好了，直接在Test中测试
 *
 *
 * 可能存在的疑问：
 *
 * 我甚至都没写在哪个表里查，为什么能自动识别是在我刚刚创建的表里查？
 *      注意我们创建的表，和对应的模型类，是同一个名，默认情况是在同名的表中查找
 * 那我要是表明和模型类的名不一样，那咋整？
 *      在模型类的上方加上@TableName注解
 *      例如数据表叫tb_user但数据类叫User，那么就在User类上加@TableName("tb_user")注解
 */