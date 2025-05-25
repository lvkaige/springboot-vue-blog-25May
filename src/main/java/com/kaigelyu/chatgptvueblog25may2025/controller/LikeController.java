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
    public Result likePost(@PathVariable Long postId, @RequestHeader("Authorization") String auth) {
        Long userId = /* parse user id from token */;
        likeService.likePost(userId, postId);
        return Result.success("已点赞帖子");
    }

    // 给评论点赞
    @PostMapping("/comment/{commentId}")
    public Result likeComment(@PathVariable Long commentId, @RequestHeader("Authorization") String auth) {
        Long userId = /* parse user id from token */;
        likeService.likeComment(userId, commentId);
        return Result.success("已点赞评论");
    }
}

