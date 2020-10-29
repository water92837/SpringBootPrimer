package com.example.homework.service;

import com.example.homework.model.User;

import java.util.List;

/**
 * Create by Administrator shui
 */
public interface UserService {

    public List<User> listAllUser();

    public User getUser(Long id);

    public int createUser(User user);

    public int deleteUser(Long id);

    //修改用户
    public int modifyUser(User user);
}
