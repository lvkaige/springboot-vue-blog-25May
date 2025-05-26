// Result.java
package com.kaigelyu.chatgptvueblog25may2025.util;

//  统一的 API 响应封装类，它在整个项目中负责标准化接口返回结构

public class Result {
    // 返回前端的只有这三个变量： success message data，前端接收数据时候需要按这个名字来接收
    private boolean success;
    private String message;
    private Object data;

    // 向前端传输三个数据
    public Result(boolean success, String message, Object data) {
        this.success = success;
        this.message = message;
        this.data = data;
    }

    // 向前端传输result数据， return Result.success("登录成功");
    public static Result success(String msg) {
        return new Result(true, msg, null);
    }

    public static Result success(Object data) {
        return new Result(true, null, data);
    }

    // 传输错误数据的时候仅仅传输message这一个变量
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
