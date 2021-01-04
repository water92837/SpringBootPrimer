package com.example.logdemo.service;

import com.example.logdemo.model.User;

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
     /**
      * 增加user
      */
     int createUser(User user);

     /**
      * 根据id删除user
      * @param id
      * @return 查询结果个数
      */
     int deleteUser(Long id);

     /**
      * 修改user
      * @param user
      * @return 修改结果数
      */
     int modifyUser(User user);
}
