package com.kaigelyu.chatgptvueblog25may2025.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

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

    @Column(nullable = false)
    private Long userId;        // 发布用户ID

    @Column(nullable = false)
    private Integer viewCount = 0;   // 浏览量，初始0

    @Column(nullable = false)
    private Integer likeCount = 0;   // 点赞数，初始0

    @Column(nullable = false)
    private Integer commentCount = 0; // 评论数，初始0

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt; // 创建时间

    @UpdateTimestamp
    private LocalDateTime updatedAt; // 更新时间


    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(int i) {
        this.likeCount = i;
    }

    public void setViewCount(int i) {
        this.viewCount = i;
    }

    public int getViewCount() {
        return viewCount;
    }

    public Long getUserId() {
        return userId;
    }
}
