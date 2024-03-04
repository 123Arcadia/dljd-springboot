package springboottestmybatisdemo.DAO;

import springboottestmybatisdemo.pojo.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

//@Mapper
public interface UserMapper {
    @Select("select id, name , address,phone as pgone, password from test.user where id=#{id}")
    User selectById(Integer id);

    @Select("select * from test.user")
    List<User> selectAll();
}
