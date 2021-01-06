package com.example.aoplogdemo.service;


import com.example.aoplogdemo.model.User;

import java.util.List;

/**
 * Create by SJS
 * Date:2020-12-31 21:01
 * Desc:服务层/业务层接口
 */
public interface UserService {
     /**
      * 查询所有user信息
      */
     List<User> listAllUser();
     /**
      * 根据id查询指定用户
      */
     User getUser(Long id);
}
