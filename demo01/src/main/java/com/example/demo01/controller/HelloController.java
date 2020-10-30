package com.example.demo01.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Create by Administrator
 * Date:2020-10-26 13:30
 */

@RestController
@RequestMapping(value = "/test")
public class HelloController {

    @RequestMapping("/hello")
    public String hello(){
        return "这是我的第一个SpringBoot项目！";
    }

}
