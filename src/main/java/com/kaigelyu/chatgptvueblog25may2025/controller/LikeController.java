package com.kaigelyu.chatgptvueblog25may2025.controller;


import com.kaigelyu.chatgptvueblog25may2025.service.LikeService;
import com.kaigelyu.chatgptvueblog25may2025.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

// LikeController.java
@RestController
@RequestMapping("/api/likes")
public class LikeController {
    @Autowired
    private LikeService likeService;

    // 给帖子点赞
    @PostMapping("/post/{postId}")
    public Result likePost(@PathVariable Long postId, @RequestParam Long userId) {
        likeService.likePost(userId, postId);
        return Result.success("已点赞帖子");
    }

    // 给评论点赞
    @PostMapping("/comment/{commentId}")
    public Result likeComment(@PathVariable Long commentId, @RequestParam Long userId) {
        likeService.likeComment(userId, commentId);
        return Result.success("已点赞评论");
    }
}

