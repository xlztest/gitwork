package com.example.my_template.response;

import com.example.my_template.enums.ResultEnum;


/**
 * @author avanline
 * @descriotion 返回数据通用实体
 * @date 2018-02-28 17:58
 */
public class Result<T> {

    private int code = ResultEnum.SUCCESS.getCode();
    private String msg = ResultEnum.SUCCESS.getMessage();
    private T data;

    Result(T data) {
        this.data = data;
    }

    Result(int code, String message) {
        this.code = code;
        this.msg = message;
    }

    Result(int code, String message, T data) {
        this.code = code;
        this.msg = message;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Result{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
