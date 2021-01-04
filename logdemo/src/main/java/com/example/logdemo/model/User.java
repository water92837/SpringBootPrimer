package com.example.logdemo.model;

import lombok.ToString;

import java.io.Serializable;

/**
 * Create by SJS
 * Date:2020-12-31 20:40
 * @ToString 作用于类上，生成包含所有参数的toString方法
 * 参考：https://blog.csdn.net/mu_wind/article/details/104844946
 */
@ToString
public class User implements Serializable {

    private static final long serialVersionUID = 3724053394486040207L;

    /**
     * 用户的id
     */
    private Long id;
    /**
     * 用户的姓名
     */
    private String name;
    /**
     * 用户的手机
     */
    private String mobile;
    /**
     * 用户的邮件
     */
    private String email;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
