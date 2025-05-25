package com.kaigelyu.chatgptvueblog25may2025.entity;

import jakarta.persistence.*;

// CommentLike.java
@Entity
@Table(name = "comment_like")
public class CommentLike {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long userId;    // 点赞用户ID
    private Long commentId; // 点赞评论ID

    public CommentLike() {

    }
}
