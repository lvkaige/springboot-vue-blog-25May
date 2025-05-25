package com.kaigelyu.chatgptvueblog25may2025.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kaigelyu.chatgptvueblog25may2025.entity.Post;
import com.kaigelyu.chatgptvueblog25may2025.respository.PostRepository; // 导入接口,便捷操作数据库
import java.util.List;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepo;

    // 发布新帖子
    public Post createPost(Post post, Long userId) {
        post.setUserId(userId);
        return postRepo.save(post);
    }

    // 获取帖子并增加浏览量
    public Post getPostById(Long id) {
        Post post = postRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("帖子不存在"));
        // 在服务层更新浏览量:contentReference[oaicite:5]{index=5}
        post.setViewCount(post.getViewCount() + 1);
        return postRepo.save(post);
    }

    // 删除帖子
    public void deletePost(Long id) {
        postRepo.deleteById(id);
    }

    // 获取全部帖子
    public List<Post> listAll() {
        return postRepo.findAll();
    }
}
