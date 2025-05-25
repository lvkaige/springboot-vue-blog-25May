package com.kaigelyu.chatgptvueblog25may2025.controller;

import com.kaigelyu.chatgptvueblog25may2025.entity.User;
import com.kaigelyu.chatgptvueblog25may2025.service.UserService;
import com.kaigelyu.chatgptvueblog25may2025.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// UserController.java (管理员添加用户)
@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;

    // 添加用户（仅管理员可用，实际中需检查当前用户角色）
    @PostMapping("/add")
    public Result addUser(@RequestBody User user) {
        userService.register(user);
        return Result.success("用户添加成功");
    }
}


