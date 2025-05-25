package com.kaigelyu.chatgptvueblog25may2025.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.kaigelyu.chatgptvueblog25may2025.entity.User;

// UserRepository.java
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}

