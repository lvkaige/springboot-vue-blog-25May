package com.kaigelyu.chatgptvueblog25may2025.entity;

import jakarta.persistence.*;

// 用户的数据表
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;    // 用户名

    @Column(nullable = false)
    private String password;    // 密码（示例中为明文）

    @Column(nullable = false)
    private Boolean admin = false; // 是否管理员

    public String getPassword() {
        return password;
    }

    // 省略getter/setter
}

