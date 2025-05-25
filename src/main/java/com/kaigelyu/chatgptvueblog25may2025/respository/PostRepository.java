package com.kaigelyu.chatgptvueblog25may2025.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.kaigelyu.chatgptvueblog25may2025.entity.Post;

// PostRepository.java
@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
}

