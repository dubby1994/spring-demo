package hello.mapper;

import hello.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;

import java.util.List;

/**
 * Created by teeyoung on 17/10/25.
 */
@Mapper
public interface UserMapper {

    List<User> findAll();

    User findById(int id);

    int insert(User user);

}
