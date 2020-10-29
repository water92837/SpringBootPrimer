package com.example.homework.service;

import com.example.homework.entity.User;

import java.util.List;

/**
 * Create by Administrator shui
 */
public interface UserService {

    /** 查询所有User */
    public List<User> listAllUser();

    /** 根据id查询一个User */
    public User getUser(Long id);

    /** 添加一个User */
    public User addUser(User user);

    /** 根据id删除一个User */
    public void deleteUser(Long id);

    /** 修改一个User */
    public User modifyUser(User user);
}
