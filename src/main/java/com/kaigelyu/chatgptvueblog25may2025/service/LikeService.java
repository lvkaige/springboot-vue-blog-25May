package com.kaigelyu.chatgptvueblog25may2025.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kaigelyu.chatgptvueblog25may2025.entity.PostLike;
import com.kaigelyu.chatgptvueblog25may2025.entity.CommentLike;
import com.kaigelyu.chatgptvueblog25may2025.entity.Post;
import com.kaigelyu.chatgptvueblog25may2025.entity.Comment;

import com.kaigelyu.chatgptvueblog25may2025.respository.PostLikeRepository;
import com.kaigelyu.chatgptvueblog25may2025.respository.CommentLikeRepository;
import com.kaigelyu.chatgptvueblog25may2025.respository.PostRepository;
import com.kaigelyu.chatgptvueblog25may2025.respository.CommentRepository;

import java.util.List;

@Service
public class LikeService {
    @Autowired
    private PostLikeRepository postLikeRepo;
    @Autowired
    private CommentLikeRepository commentLikeRepo;
    @Autowired
    private PostRepository postRepo;
    @Autowired
    private CommentRepository commentRepo;

    // 给帖子点赞
    public void likePost(Long userId, Long postId) {
        // 判断是否已点赞
        boolean exists = postLikeRepo.existsByUserIdAndPostId(userId, postId);
        if (!exists) {
            postLikeRepo.save(new PostLike(null, userId, postId));
            Post post = postRepo.findById(postId).orElseThrow();
            post.setLikeCount(post.getLikeCount() + 1);
            postRepo.save(post);
        }
    }

    // 给评论点赞（逻辑类似）
    public void likeComment(Long userId, Long commentId) {
        boolean exists = commentLikeRepo.existsByUserIdAndCommentId(userId, commentId);
        if (!exists) {
            commentLikeRepo.save(new CommentLike(null, userId, commentId));
            Comment comment = commentRepo.findById(commentId).orElseThrow();
            comment.setLikeCount(comment.getLikeCount() + 1);
            commentRepo.save(comment);
        }
    }
}

