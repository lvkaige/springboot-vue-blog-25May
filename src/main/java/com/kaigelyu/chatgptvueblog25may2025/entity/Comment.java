package com.kaigelyu.chatgptvueblog25may2025.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

// Comment.java
@Entity
@Table(name = "comment")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long postId;       // 所属帖子ID

    @Column(nullable = false)
    private Long userId;       // 发布用户ID

    @Column(nullable = true)
    private Long parentId;     // 父评论ID，null表示顶级评论

    @Column(nullable = false, columnDefinition="TEXT")
    private String content;    // 评论内容

    @Column(nullable = false)
    private Integer likeCount = 0; // 点赞数，初始0

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt; // 创建时间

    public Integer getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(int i) {
    }

    public void setUserId(Long userId) {
    }
}

