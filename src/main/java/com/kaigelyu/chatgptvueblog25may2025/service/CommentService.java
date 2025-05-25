package com.kaigelyu.chatgptvueblog25may2025.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kaigelyu.chatgptvueblog25may2025.entity.Comment;
import com.kaigelyu.chatgptvueblog25may2025.respository.CommentRepository;
import java.util.List;

@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepo;

    // 添加评论或回复
    public Comment addComment(Comment comment) {
        return commentRepo.save(comment);
    }

    // 获取某帖子的所有评论
    public List<Comment> getCommentsByPost(Long postId) {
        return commentRepo.findByPostId(postId);
    }
}

