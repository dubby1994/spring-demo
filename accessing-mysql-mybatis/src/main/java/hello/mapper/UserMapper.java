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

    @Select("SELECT * FROM USER")
    List<User> findAll();

    @Select("SELECT * FROM USER WHERE ID = #{id}")
    User findById(int id);

    @Insert("INSERT INTO USER(email, name) values(#{email}, #{name})")
    @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id", before = false, resultType = Integer.class)
    int insert(User user);

}
