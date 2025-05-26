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

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", admin=" + admin +
                '}';
    }

    public void setAdmin(boolean b) {
        admin = b;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public Boolean getAdmin() {
        return admin;
    }

    public void setAdmin(Boolean admin) {
        this.admin = admin;
    }

}

