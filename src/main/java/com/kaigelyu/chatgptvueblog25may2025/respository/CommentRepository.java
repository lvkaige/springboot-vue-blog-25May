package com.kaigelyu.chatgptvueblog25may2025.respository;

// CommentRepository.java
@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByPostId(Long postId);
}
