package com.kaigelyu.chatgptvueblog25may2025.entity;

import jakarta.persistence.*;

// Comment.java
@Entity
@Table(name = "comment")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "post_id", nullable = false)
    private Long postId;       // 所属帖子ID

    @Column(name = "user_id", nullable = false)
    private Long userId;       // 发布用户ID

    @Column(name = "parent_id")
    private Long parentId;     // 父评论ID，null表示顶级评论

    @Column(nullable = false, columnDefinition="TEXT")
    private String content;    // 评论内容

    @Column(name = "like_count", nullable = false)
    private Integer likeCount = 0; // 点赞数，初始0

    public Integer getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(int i) {
    }

    public void setUserId(Long userId) {
    }

    // 省略getter/setter
}

