package com.example.homework.model;

import java.io.Serializable;

/**
 * Create by Administrator shui
 * User的实体类
 */
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
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
