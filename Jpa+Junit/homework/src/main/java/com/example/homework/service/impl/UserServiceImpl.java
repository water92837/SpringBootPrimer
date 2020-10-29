package com.example.homework.service.impl;

import com.example.homework.dao.UserJpa;
import com.example.homework.entity.User;
import com.example.homework.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Create by Administrator shui
 * UserService实现类
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserJpa userJpa;

    @Override
    public List<User> listAllUser() {
        return userJpa.findAll();
    }

    @Override
    public User getUser(Long id) {
        Optional<User> optional = userJpa.findById(id);
        if(optional.isPresent()){   //Optional中存在的值不为null时返回true
            User user = optional.get();
            return user;
        }
        return null;//Optional中不存在值
    }

    @Override
    public User addUser(User user) {
        //将返回的实例用于进一步的操作，因为save操作可能已完全更改了实体实例
        User userSaved = userJpa.save(user);
        return userSaved;
    }

    @Override
    public void deleteUser(Long id) {
        userJpa.deleteById(id);
    }

    @Override
    public User modifyUser(User user) {
        //保存实体并立即刷新更改  返回保存的实体
        User userSaved = userJpa.saveAndFlush(user);
        return userSaved;
    }
}
