package com.example.my_template.enums;

public enum ResultEnum {
    SUCCESS(100, "操作成功"),
    FAIL(101, "操作失败"),
    LOGIN(102, "未登录"),
    SERVICE_ERROR(-1,"未知错误");

    private int code;
    private String message;

    ResultEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}