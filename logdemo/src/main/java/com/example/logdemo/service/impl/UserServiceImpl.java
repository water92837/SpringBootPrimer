package com.example.logdemo.service.impl;

import com.example.logdemo.mapper.UserMapper;
import com.example.logdemo.model.User;
import com.example.logdemo.service.UserService;
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

    /**
     * 增加user
     * @param user
     */
    @Override
    public int createUser(User user) {
        return userMapper.insert(user);
    }

    /**
     * 根据id删除user
     * @param id
     * @return 查询结果个数
     */
    @Override
    public int deleteUser(Long id) {
        return userMapper.deleteById(id);
    }

    /**
     * 修改user
     * remark：实际上还是根据用户ID修改用户信息
     * @param user
     * @return 修改结果数
     */
    @Override
    public int modifyUser(User user) {
        return userMapper.update(user);
    }
}
