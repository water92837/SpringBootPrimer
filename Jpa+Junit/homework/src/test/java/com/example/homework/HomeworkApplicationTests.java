package com.example.homework;

import com.example.homework.entity.User;
import com.example.homework.service.UserService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
class HomeworkApplicationTests {

    @Autowired
    private UserService userService;//注入Service对象

    @Test
    void contextLoads() {
    }

    private void printUserInfo(User user){
        System.out.println("id = "+ user.getId() +
                "; name = " + user.getName() +
                "; mobile = " + user.getMobile() +
                "; email = " + user.getEmail());
    }

    @Test
    public void testListAllUser() {
        List<User> userList = userService.listAllUser();
        for (User user:userList) {
            printUserInfo(user);
        }
    }

    @Test
    public void testGetUser() {
        User user = userService.getUser(2L);
        //user不为null 断言通过 说明查询到信息;
        //为null就是没有查询到 此时Assert.assertNotNull(null)会报错
        Assert.assertNotNull(user);
        printUserInfo(user);
    }

    @Test
    public void testAddUser() {
        User user = new User();
        //user.setId(20L);//id自动增长  不需要设id
        user.setName("单元测试");
        user.setMobile("1000000000");
        user.setEmail("dycs@test.com");
        User userSaved = userService.addUser(user);
        Assert.assertNotNull(userSaved);
        printUserInfo(userSaved);
    }

    @Test
    public void testDeleteUser() {
        Long id = 10L;
        User deleteUser = userService.getUser(id);
        //要删除的用户存在  即deleteUser!=null
        Assert.assertNotNull(deleteUser);
        userService.deleteUser(id);
        System.out.println("删除 id = "+ id +" 的用户成功！！");
    }

    @Test
    public void testModifyUser(){
        Long id = 5L;
        User updateUser = userService.getUser(id);
        //要修改的用户存在  即updateUser!=null
        Assert.assertNotNull(updateUser);
        User user = new User();
        user.setId(id);
        user.setName("黑豹");
        user.setMobile("01234567891");
        user.setEmail("BlackPanther@manwei.com");
        User userSaved = userService.modifyUser(user);
        System.out.println("修改后 id = "+ id +" 的用户信息为:");
        printUserInfo(userSaved);
    }

}
