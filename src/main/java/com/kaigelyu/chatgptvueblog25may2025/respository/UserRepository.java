package com.kaigelyu.chatgptvueblog25may2025.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.kaigelyu.chatgptvueblog25may2025.entity.User;

// UserRepository.java
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // 这是一个 自动查询方法，Spring Data JPA 会根据方法名自动生成 SQL 查询语句
    // 从而在数据库中通过用户名查找用户对象。
    User findByUsername(String username);
}

