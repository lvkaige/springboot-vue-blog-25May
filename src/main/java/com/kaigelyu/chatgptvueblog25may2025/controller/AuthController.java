package com.kaigelyu.chatgptvueblog25may2025.controller;// 本文件类似于django里的views

import com.kaigelyu.chatgptvueblog25may2025.entity.User;
import com.kaigelyu.chatgptvueblog25may2025.respository.UserRepository;
import com.kaigelyu.chatgptvueblog25may2025.service.UserService;
import com.kaigelyu.chatgptvueblog25may2025.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;

    // 用户注册
    @PostMapping("/register")
    public Result register(@RequestBody User user) {
//        System.out.println("AuthController 注册信息：" + user);
        if (Objects.equals(user.getUsername(), "") || Objects.equals(user.getPassword(), "")) {
            return Result.error("用户名或密码不能为空");
        }

        if (userRepository.findByUsername(user.getUsername()) != null) {
            return Result.error("用户名已存在，请更换一个");
        }
        user.setAdmin(false); // 设置默认非管理员
        // 调用写的接口来注册用户，实际上这个接口可以不用谢
        userService.register(user);
        return Result.success("注册成功");
    }

    // 用户登录
    @PostMapping("/login")
    public Result login(@RequestBody Map<String, String> creds) {
        // 前端传来的数据是账号与密码两个字符串的参数username与password，这里将他们保存为一个map
        // 调用接口，找到这个账号对应的user对象，
        // System.out.println("前端传来的数据" + creds.get("username") + creds.get("password"));
        User user = userService.findByUsername(creds.get("username"));
        if (user == null || !user.getPassword().equals(creds.get("password"))) {
            return Result.error("用户名或密码错误");
        }
        return Result.success("登录成功");
    }
}
