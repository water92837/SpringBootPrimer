package com.example.homework;

import com.example.homework.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
class HomeworkApplicationTests {

    @Autowired
    private UserService userService;//注入Service对象

    @Test
    void contextLoads() {
    }

}
