package com.example.logdemo;

import com.example.logdemo.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class LogdemoApplicationTests {

    @Test
    void contextLoads() {
        User user = new User();
        user.setId(100L);
        user.setName("天下空");
        user.setMobile("12345678");
        user.setEmail("tmm@126.com");
        System.out.println(user);
    }

}
