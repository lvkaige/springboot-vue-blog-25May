package com.kaigelyu.chatgptvueblog25may2025.service;
// controller里面函数的补充，
// 这个文件是不必要的（在controller里就可以完成）
// 但是，service文件夹内的文件是操作数据库模型的函数，和controller划分了界限，一个主要处理逻辑、一个主要处理数据库

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kaigelyu.chatgptvueblog25may2025.entity.User;
import com.kaigelyu.chatgptvueblog25may2025.respository.UserRepository; // 导入接口,便捷操作数据库

@Service
public class UserService {
    @Autowired
    private UserRepository userRepo;

    // 注册新用户
    public User register(User user) {
//        System.out.println("注册用户信息：" + user);
        // userRepo是指调用数据访问层
        return userRepo.save(user);
    }

    // 通过用户名查找用户（用于登录校验）
    public User findByUsername(String username) {
        return userRepo.findByUsername(username);
    }

    // 后续可添加其他用户相关逻辑
}

