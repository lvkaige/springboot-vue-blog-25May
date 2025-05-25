package com.kaigelyu.chatgptvueblog25may2025.entity;

import jakarta.persistence.*;

// Post.java
@Entity
@Table(name = "post")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;       // 帖子标题

    @Column(nullable = false, columnDefinition="TEXT")
    private String content;     // 帖子内容

    @Column(name = "user_id", nullable = false)
    private Long userId;        // 发布用户ID

    @Column(name = "view_count", nullable = false)
    private Integer viewCount = 0;   // 浏览量，初始0

    @Column(name = "like_count", nullable = false)
    private Integer likeCount = 0;   // 点赞数，初始0

    @Column(name = "comment_count", nullable = false)
    private Integer commentCount = 0; // 评论数，初始0

    public void setUserId(Long userId) {
    }

    // 省略getter/setter
}
