package com.example.homework.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Create by Administrator shui
 * User的实体类
 */

@Entity
@Table(name="user")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    /** 用户的id */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//指示持久性提供程序必须使用数据库标识列为实体分配主键。
    @Column(name = "id")
    private Long id;

    /** 用户的姓名 */
    @Column(name = "name")
    private String name;

    /** 用户的手机 */
    @Column(name = "mobile")
    private String mobile;

    /** 用户的邮件 */
    @Column(name = "email")
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
