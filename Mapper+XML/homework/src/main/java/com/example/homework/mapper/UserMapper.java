package com.example.homework.mapper;

import com.example.homework.model.User;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

/**
 * Create by Administrator shui
 * DAO层访问数据库接口
 * 并在resources中编写mapper/UserMapper.xml文件
 */
//需要使用@Mapper注解,不然SpringBoot无法扫描
@Mapper
public interface UserMapper {

    /**
     * 查询所有数据
     */
    public List<User> findAll();

    /**
     * 根据id查询数据
     */
    public User findById(Long id);

    /**
     * 根据实体对象插入数据
     */
    public int insert(User user);

    /**
     * 根据id删除指定数据
     */
    public int deleteById(Long id);

    /**
     * 根据id更新用户信息
     */
    public int update(User user);

}
