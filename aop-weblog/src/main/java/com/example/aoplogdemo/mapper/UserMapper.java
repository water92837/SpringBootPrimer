package com.example.aoplogdemo.mapper;


import com.example.aoplogdemo.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Create by SJS
 * Date:2020-12-31 20:56
 * Desc:DAO层访问数据库接口, 本例使用注解的方式 实现DAO层CRUD接口
 */
//需要使用@Mapper注解,不然SpringBoot无法扫描
@Mapper
public interface UserMapper {

    /**
     * 查询所有数据
     */
    @Select("select id, name, mobile, email from user")
    List<User> findAll();

    /**
     * 根据id查询数据
     */
    @Select("select * from user where id = #{id}")
    User findById(Long id);

}
