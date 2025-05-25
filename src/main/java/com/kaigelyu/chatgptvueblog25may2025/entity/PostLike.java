package com.kaigelyu.chatgptvueblog25may2025.entity;

import jakarta.persistence.*;

// PostLike.java
@Entity
@Table(name = "post_like")
public class PostLike {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long userId;    // 点赞用户ID
    private Long postId;    // 点赞帖子ID

    // 有参构造函数
    public PostLike(Long id, Long userId, Long postId) {
        this.id = id;
        this.userId = userId;
        this.postId = postId;
    }

    // 无参构造函数 JPA必须的
    public PostLike() {

    }
}

