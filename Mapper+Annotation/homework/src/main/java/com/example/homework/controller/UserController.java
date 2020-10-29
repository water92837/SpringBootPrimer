package com.example.homework.controller;

import com.example.homework.model.User;
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
     */
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public Object createUser(@RequestParam(value = "id", required = true) Long id,
                             @RequestParam(value = "name", required = true) String name,
                             @RequestParam(value = "mobile", required = false) String mobile,
                             @RequestParam(value = "email", required = false) String email
                            ){
        Map<String, Object> result = new HashMap<String, Object>();
        try {
            //不存在要添加的user信息 即可以添加
            if(userService.getUser(id) == null) {
                User user = new User();
                user.setId(id);
                user.setName(name);
                user.setMobile(mobile);
                user.setEmail(email);
                int count = userService.createUser(user);
                if(count > 0) {
                    result.put("status", "User created successfully");
                    result.put("user", user);
                }
                else {
                    result.put("status", "failure");
                    result.put("errMsg", "用户创建失败");
                }
            } else {
                result.put("status", "failure");
                result.put("warning", "不能重复添加已存在的用户信息!");
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
                int count = userService.deleteUser(id);
                if(count > 0) {
                    result.put("status", "deleted id = " + id +" user successfully");
                } else {
                    result.put("status", "failure");
                    result.put("errMsg", "用户删除失败");
                }
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
                int count = userService.modifyUser(user);
                if(count > 0) {
                    result.put("status", "update id = " + id +" user successfully");
                    //将最新的user信息放入结果中
                    result.put("user", user);
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
