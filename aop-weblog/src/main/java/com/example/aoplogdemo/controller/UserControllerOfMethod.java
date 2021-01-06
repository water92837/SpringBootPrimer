package com.example.aoplogdemo.controller;

import com.example.aoplogdemo.common.aop.ControllerWebLogOfMethod;
import com.example.aoplogdemo.model.User;
import com.example.aoplogdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Create by SJS
 * Date:2020-12-31 13:57
 * Desc:基于方法的切面测试接口
 */
@RestController
@RequestMapping(value="/user")
public class UserControllerOfMethod {

    @Autowired
    private UserService userService; //注入UserServiceImpl对象

    /**
     * 获取指定user信息
     */
    @GetMapping("/detail/{id}")
    @ControllerWebLogOfMethod(name = "获取单个用户的信息(基于方法的切面demo)", intoDb = true)//基于方法的Web日志注解
    public Object getOneUser(@PathVariable Long id) {
        //log.info("获取指定用户id={}的信息",id);//参数占位格式 记录info 改用AOP
        System.out.println("----------------getOneUser()方法体开始执行----------------");
        Map<String, Object> result = new HashMap<String, Object>();
        try {
            User user = userService.getUser(id);
            if(user != null) {
                result.put("status", "ok");
                result.put("user", user);
            }
            else {
                result.put("status", "failure");
                result.put("errMsg", "用户信息不存在!");
            }
        } catch (Exception e) {
            result.put("status", "failure");
            result.put("errMsg", e.getMessage());
            //log.error(e.getMessage(), e);//改用AOP
        }
        System.out.println("----------------getOneUser()方法体结束执行----------------");
        return result;
    }


    @GetMapping("/getOne")
    @ControllerWebLogOfMethod(name = "查询测试", intoDb = true)
    public String getOne(Long id, String name) {
        System.out.println("----------------getOne() Body Start----------------");
        if(id < 0) {
            throw new IllegalArgumentException("getOne()方法参数异常");
        }
        System.out.println("----------------getOne() Body End----------------");
        return "1234";
    }

}
