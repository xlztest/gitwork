package com.example.my_template.response;


import com.example.my_template.enums.ResultEnum;

/**
 * @author avanline
 * @descriotion
 * @date 2018-02-28 18:07
 */
public class ResultUtil {

    public static <T> Result<T> success() {
        return new Result<>(null);
    }

    public static <T> Result<T> success(T data) {
        return new Result<>(data);
    }

    public static <T> Result<T> error(ResultEnum resultEnum) {
        return error(resultEnum.getCode(), resultEnum.getMessage());
    }

    public static <T> Result<T> error(String message, T data) {
        return new Result<>(ResultEnum.SERVICE_ERROR.getCode(), message, data);
    }

    public static <T> Result<T> error() {
        return new Result<>(ResultEnum.SERVICE_ERROR.getCode(), ResultEnum.SERVICE_ERROR.getMessage());
    }

    public static <T> Result<T> error(String message) {
        return new Result<>(0, message);
    }

    public static <T> Result<T> error(int code, String message) {
        return new Result<>(code, message);
    }
}
