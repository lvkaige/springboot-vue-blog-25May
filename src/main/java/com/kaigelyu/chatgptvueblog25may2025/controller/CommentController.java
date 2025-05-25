package com.kaigelyu.chatgptvueblog25may2025.controller;

import com.kaigelyu.chatgptvueblog25may2025.entity.Comment;
import com.kaigelyu.chatgptvueblog25may2025.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// CommentController.java
@RestController
@RequestMapping("/api/comments")
public class CommentController {
    @Autowired
    private CommentService commentService;

    // 添加评论或回复（parentId可选）
    @PostMapping("/")
    public Comment addComment(@RequestBody Comment comment, @RequestParam Long userId) {
        comment.setUserId(userId);
        return commentService.addComment(comment);
    }

    // 根据帖子获取评论列表（可根据parentId进行多级组织）
    @GetMapping("/post/{postId}")
    public List<Comment> getComments(@PathVariable Long postId) {
        return commentService.getCommentsByPost(postId);
    }
}

