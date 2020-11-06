package com.example.homework.dao;

import com.example.homework.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.io.Serializable;

/**
 * Create by Administrator shui
 * 使用Jpa访问数据库 继承接口JpaRepository，在启动时jpa会自动生成它的实现类
 * JpaRepository:提供的简单数据操作接口 有一些基本的数据操作方法
 *               如增删改查、分页查询、排序查询等
 * 
 */
public interface UserJpa extends JpaRepository<User,Long> {

}
