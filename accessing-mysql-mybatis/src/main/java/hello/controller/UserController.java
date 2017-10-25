package hello.controller;

import hello.entity.User;
import hello.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by teeyoung on 17/10/25.
 */
@RestController
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @RequestMapping(value = "user/list")
    public List<User> list() {
        return userMapper.findAll();
    }

    @RequestMapping(value = "user/{id}")
    public User list(@PathVariable("id") int id) {
        return userMapper.findById(id);
    }

    @RequestMapping(value = "user/create")
    public List<User> create(String name, String email) {
        User temp = new User(name, email);
        int result = userMapper.insert(temp);
        System.out.println(temp.toString());
        System.out.println("result:" + result);
        return list();
    }

}
