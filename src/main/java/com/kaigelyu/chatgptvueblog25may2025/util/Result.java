package com.kaigelyu.chatgptvueblog25may2025.util;

//  统一的 API 响应封装类，它在整个项目中负责标准化接口返回结构

public class Result {
    private boolean success;
    private String message;
    private Object data;

    public Result(boolean success, String message, Object data) {
        this.success = success;
        this.message = message;
        this.data = data;
    }

    public static Result success(String msg) {
        return new Result(true, msg, null);
    }

    public static Result success(Object data) {
        return new Result(true, null, data);
    }

    public static Result error(String msg) {
        return new Result(false, msg, null);
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
