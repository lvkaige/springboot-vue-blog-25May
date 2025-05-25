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
    public Post createPost(@RequestBody Post post, @RequestParam Long userId) {
        return postService.createPost(post, userId);
    }

    // 删除帖子（普通用户只能删自己帖子，管理员可删任意）
    @DeleteMapping("/{id}")
    public Result deletePost(@PathVariable Long id,
                             @RequestParam Long userId,
                             @RequestParam(defaultValue = "false") boolean isAdmin) {
        Post post = postService.getPostById(id);
        if (post == null) {
            return Result.error("帖子不存在");
        }

        if (!isAdmin && !post.getUserId().equals(userId)) {
            return Result.error("无权限删除该帖子");
        }

        postService.deletePost(id);
        return Result.success("删除成功");
    }

}

