package com.kaigelyu.chatgptvueblog25may2025.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.kaigelyu.chatgptvueblog25may2025.entity.Comment;

import java.util.List;


// CommentRepository.java
@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByPostId(Long postId);
}
