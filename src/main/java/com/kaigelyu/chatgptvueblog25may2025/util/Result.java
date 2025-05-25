package com.kaigelyu.chatgptvueblog25may2025.util;

import java.util.HashMap;
import java.util.Map;

public class Result {
    private boolean success;
    private String message;
    private Object data;

    public static Result success(String msg) {
        return new Result(true, msg, null);
    }

    public static Result success(Object data) {
        return new Result(true, null, data);
    }

    public static Result error(String msg) {
        return new Result(false, msg, null);
    }

    // 构造函数、getter/setter略
}

