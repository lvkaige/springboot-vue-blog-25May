// CommentLikeRepository.java
package com.kaigelyu.chatgptvueblog25may2025.respository;

import com.kaigelyu.chatgptvueblog25may2025.entity.CommentLike;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentLikeRepository extends JpaRepository<CommentLike, Long> {
    boolean existsByUserIdAndCommentId(Long userId, Long commentId);
}
