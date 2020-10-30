package com.example.homework.service.impl;

import com.example.homework.mapper.UserMapper;
import com.example.homework.model.User;
import com.example.homework.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Create by Administrator shui
 * UserService实现类
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper; //注入Dao对象到Servive层

    @Override
    public List<User> listAllUser() {
        List<User> userList = userMapper.findAll();
        return userList;
    }

    @Override
    public User getUser(Long id) {
        return userMapper.findById(id);
    }

    @Override
    public int createUser(User user) {
        int count = userMapper.insert(user);
        return count;
    }

    @Override
    public int deleteUser(Long id) {
        int count = userMapper.deleteById(id);
        return count;
    }

    /**
     * 修改用户信息
     * remark：实际上还是根据用户ID修改用户信息
     * @param user
     * @return 数据库受影响的行数
     */
    @Override
    public int modifyUser(User user) {
        return userMapper.update(user);
    }
}
