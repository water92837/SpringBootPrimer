package com.example.aoplogdemo.service.impl;

import com.example.aoplogdemo.mapper.UserMapper;
import com.example.aoplogdemo.model.User;
import com.example.aoplogdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Create by SJS
 * Date:2020-12-31 21:07
 * Desc: UserService实现类
 * 注意：需要在接口实现类中使用@Service注解，才能被SpringBoot扫描，
 * 在Controller中使用@Autowired注入
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper; //注入Dao层对象到Servive层

    /**
     * 查询所有user信息
     */
    @Override
    public List<User> listAllUser() {
        List<User> userList = userMapper.findAll();
        return userList;
    }

    /**
     * 根据id查询指定用户
     * @param id
     */
    @Override
    public User getUser(Long id) {
        return userMapper.findById(id);
    }
}
