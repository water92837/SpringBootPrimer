package com.example.logdemo.mapper;

import com.example.logdemo.model.User;
import org.apache.ibatis.annotations.*;

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

    /**
     * 根据实体对象插入数据
     */
    @Insert("insert into user (id, name, mobile, email) values (#{id}, #{name}, #{mobile}, #{email})")
    int insert(User user);

    /**
     * 根据id删除指定数据
     */
    @Delete("delete from user where id = #{id}")
    int deleteById(Long id);

    /**
     * 根据id更新用户信息
     */
    @Update("update user set name = #{name}, mobile = #{mobile}, email = #{email} where id = #{id}")
    int update(User user);

}
