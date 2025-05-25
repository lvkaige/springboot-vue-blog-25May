// PostLikeRepository.java
package com.kaigelyu.chatgptvueblog25may2025.respository;

import com.kaigelyu.chatgptvueblog25may2025.entity.PostLike;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostLikeRepository extends JpaRepository<PostLike, Long> {
    boolean existsByUserIdAndPostId(Long userId, Long postId);
}

