package com.example.homework.controller;

import com.example.homework.entity.User;
import com.example.homework.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Create by Administrator shui
 */
@RestController
@RequestMapping(value="/user")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService; //注入UserServiceImpl对象

    /**
     * 获得所有user信息
     */
    @RequestMapping(value = "/list" , method = RequestMethod.GET)
    public Object getAllUser() {
        Map<String,Object> result = new HashMap<>();
        try {
            List<User> userList = userService.listAllUser();
            result.put("userList", userList);
            result.put("status", "ok");
        } catch (Exception e) {
            result.put("status", "failure");
            result.put("errMsg", e.getMessage());
            logger.error(e.getMessage(), e);
        }
        return result;
    }

    /**
     * 获取指定user信息
     */
    @RequestMapping(value = "/detail/{id}",method = RequestMethod.GET)
    public Object getUserDetail(@PathVariable Long id) {
        Map<String, Object> result = new HashMap<String, Object>();
        try {
            User user = userService.getUser(id);
            if(user != null) {
                result.put("user", user);
                result.put("status", "ok");
            }
            else {
                result.put("status", "failure");
                result.put("errMsg", "用户信息不存在!");
            }
        } catch (Exception e) {
            result.put("status", "failure");
            result.put("errMsg", e.getMessage());
            logger.error(e.getMessage(), e);
        }
        return result;
    }

    /**
     * 添加用户信息
	 * 使用Jpa时需要将Mysql主键id设为自动增长 否则插入会报错
     */
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public Object createUser(
                             /*@RequestParam(value = "id", required = true) Long id,*/
                             @RequestParam(value = "name", required = true) String name,
                             @RequestParam(value = "mobile", required = false) String mobile,
                             @RequestParam(value = "email", required = false) String email
                            ){
        Map<String, Object> result = new HashMap<String, Object>();
        try {
            User user = new User();
            //主键id自动增长 底层sql语句不涉及id属性 因此主键id应设为自动增长
            //insert into user (email, mobile, name) values (?, ?, ?)
            //也不需要校验id 即要添加的用户信息的id肯定是不同的
            //user.setId(id);
            user.setName(name);
            user.setMobile(mobile);
            user.setEmail(email);
            User userSaved = userService.addUser(user);
            if(userSaved != null) {
                result.put("status", "User Created Successfully");
                result.put("userSaved", userSaved);
            }
            else {
                result.put("status", "failure");
                result.put("errMsg", "用户创建失败");
            }

        } catch (Exception e) {
            result.put("status", "failure");
            result.put("errMsg", e.getMessage());
            logger.error(e.getMessage(), e);
        }
        return result;
    }

    /**
     * 删除指定user
     */
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public Object deleteUser(@PathVariable Long id) {
        Map<String, Object> result = new HashMap<String, Object>();
        try {
            User user = userService.getUser(id);
            if(user != null) { //要删除的用户存在
                userService.deleteUser(id);
                result.put("status", "deleted id = " + id +" user successfully");
                //保存删除的用户信息
                result.put("user",user);
            }
            else {
                result.put("status", "failure");
                result.put("warning", "要删除的用户信息不存在!");
            }

        } catch (Exception e) {
            result.put("status", "failure");
            result.put("errMsg", e.getMessage());
            logger.error(e.getMessage(), e);
        }
        return result;
    }


    /**
     * 修改用户信息
     */
    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public Object updateUser(@RequestParam(value = "id", required = true) Long id,
                             @RequestParam(value = "name", required = true) String name,
                             @RequestParam(value = "mobile", required = true) String mobile,
                             @RequestParam(value = "email", required = true) String email) {
        Map<String, Object> result = new HashMap<String, Object>();
        try {
            //要修改的user存在
            if(userService.getUser(id) != null) {
                User user = new User();
                user.setId(id);
                user.setName(name);
                user.setMobile(mobile);
                user.setEmail(email);
                User userSaved = userService.modifyUser(user);
                if(userSaved != null) {
                    result.put("status", "Update id = " + id +" user successfully");
                    //将最新的user信息放入结果中
                    result.put("userSaved", userSaved);
                } else {
                    result.put("status", "failure");
                    result.put("errMsg", "用户更新失败");
                }
            }
            else {
                result.put("status", "failure");
                result.put("warning", "要更新的用户信息不存在!");
            }

        } catch (Exception e) {
            result.put("status", "failure");
            result.put("errMsg", e.getMessage());
            logger.error(e.getMessage(), e);
        }
        return result;
    }

}
