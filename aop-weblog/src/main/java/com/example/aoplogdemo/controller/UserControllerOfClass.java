package com.example.aoplogdemo.controller;

import com.example.aoplogdemo.common.aop.ControllerWebLogOfClass;
import com.example.aoplogdemo.model.User;
import com.example.aoplogdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Create by SJS
 * Date:2020-12-31 21:19
 * Desc:基于类的切面测试接口
 */
@RestController
@RequestMapping("/user")
@ControllerWebLogOfClass(name = "基于类的切面demo",intoDb = true)//使用基于类的Web日志注解
public class UserControllerOfClass {

    @Autowired
    private UserService userService; //注入UserServiceImpl对象

    /**
     * 获得所有user信息
     * http://localhost:8080/user/list
     */
    @RequestMapping(value = "/list" , method = RequestMethod.GET)
    public Object getAllUser() {
        //log.info("获得所有用户信息列表");//记录info 改用AOP
        System.out.println("----------------getAllUser()方法体开始执行----------------");
        Map<String,Object> result = new HashMap<>();
        try {
            List<User> userList = userService.listAllUser();
            result.put("userList", userList);
            result.put("status", "ok");
        } catch (Exception e) {
            result.put("status", "failure");
            result.put("errMsg", e.getMessage());
            //log.error(e.getMessage(), e);//记录error 改用AOP
        }
        System.out.println("----------------getAllUser()方法体结束执行----------------");
        return result;
    }

    //http://localhost:8080/user/getTwo?id=1&name=Savage
    @GetMapping("/getTwo")
    public String getTwo(Long id, String name) {
        System.out.println("----------------getTwo() Body Start----------------");
        if(id < 0 || name == null) {
            throw new IllegalArgumentException("getTwo()方法参数异常");
        }
        System.out.println("----------------getTwo() Body End----------------");
        return "5678";
    }



}
