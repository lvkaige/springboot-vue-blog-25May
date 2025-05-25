package com.kaigelyu.chatgptvueblog25may2025.controller;

import com.kaigelyu.chatgptvueblog25may2025.entity.Post;
import com.kaigelyu.chatgptvueblog25may2025.service.PostService;
import com.kaigelyu.chatgptvueblog25may2025.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// PostController.java
@RestController
@RequestMapping("/api/posts")
public class PostController {
    @Autowired
    private PostService postService;

    // 获取所有帖子列表
    @GetMapping("/")
    public List<Post> listPosts() {
        return postService.listAll();
    }

    // 获取帖子详情（并增加浏览量）
    @GetMapping("/{id}")
    public Post getPost(@PathVariable Long id) {
        return postService.getPostById(id);
    }

    // 发布新帖
    @PostMapping("/")
    public Post createPost(@RequestBody Post post, @RequestHeader("Authorization") String auth) {
        // 从Token获取当前用户ID（简化示例，不做实际解析）
        Long userId =  /* parse user id from token */;
        return postService.createPost(post, userId);
    }

    // 删除帖子（普通用户只能删自己帖子，管理员可删任意）
    @DeleteMapping("/{id}")
    public Result deletePost(@PathVariable Long id, @RequestHeader("Authorization") String auth) {
        // 从Token获取当前用户信息
        Long userId =  /* parse user id from token */;
        boolean isAdmin =  /* parse admin flag */;
        Post post = postService.getPostById(id);
        if (!isAdmin && !post.getUserId().equals(userId)) {
            return Result.error("无权限删除该帖子");
        }
        postService.deletePost(id);
        return Result.success("删除成功");
    }
}

