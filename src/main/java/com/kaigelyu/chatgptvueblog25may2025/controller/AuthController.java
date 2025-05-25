package com.kaigelyu.chatgptvueblog25may2025.controller;

import com.kaigelyu.chatgptvueblog25may2025.entity.User;
import com.kaigelyu.chatgptvueblog25may2025.service.UserService;
import com.kaigelyu.chatgptvueblog25may2025.util.JwtUtil;
import com.kaigelyu.chatgptvueblog25may2025.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

// AuthController.java (用于注册和登录)
@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    private UserService userService;
    @Autowired
    private JwtUtil jwtUtil;

    // 用户注册
    @PostMapping("/register")
    public Result register(@RequestBody User user) {
        userService.register(user);
        return Result.success("注册成功");
    }

    // 用户登录，成功返回Token
    @PostMapping("/login")
    public Result login(@RequestBody Map<String, String> creds) {
        User user = userService.findByUsername(creds.get("username"));
        if (user == null || !user.getPassword().equals(creds.get("password"))) {
            return Result.error("用户名或密码错误");
        }
        String token = jwtUtil.generateToken(user);
        return Result.success(Map.of("token", token));
    }
}
