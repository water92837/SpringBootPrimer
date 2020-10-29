package com.example.homework.mapper;

import com.example.homework.model.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Create by Administrator shui
 * DAO层访问数据库接口
 */
//需要使用@Mapper注解,不然SpringBoot无法扫描
@Mapper
public interface UserMapper {

    /**
     * 查询所有数据
     */
    @Select("select id, name, mobile, email from user")
    public List<User> findAll();

    /**
     * 根据id查询数据
     */
    @Select("select * from user where id = #{id}")
    public User findById(Long id);

    /**
     * 根据实体对象插入数据
     */
    @Insert("insert into user (id, name, mobile, email) values (#{id}, #{name}, #{mobile}, #{email})")
    public int insert(User user);

    /**
     * 根据id删除指定数据
     */
    @Delete("delete from user where id = #{id}")
    public int deleteById(Long id);

    /**
     * 根据id更新用户信息
     */
    @Update("update user SET name = #{name},mobile = #{mobile},email = #{email} WHERE id = #{id}")
    public int update(User user);

}
