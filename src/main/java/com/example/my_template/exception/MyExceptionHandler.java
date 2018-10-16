package com.example.my_template.exception;

import org.apache.http.HttpRequest;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * 异常处理器
 */

@ControllerAdvice
public class MyExceptionHandler {

    //浏览器客户端返回的都是json
    @ResponseBody
    @ExceptionHandler(UserNoExistException.class)
    public Map<String,Object> handleException(Exception e){

        Map<String,Object> map=new HashMap<>();
        map.put("code","100");
        map.put("message",e.getMessage());
        return map;
    }

   /* @ExceptionHandler(UserNoExistException.class)
    public String handleException(Exception e,HttpServletRequest request){

        //Map<String,Object> map=new HashMap<>();
        //传入自己定义的错误状态码,否则不会进入错误页面
        //request.setAttribute("javax.servlet.error.status_code",200);
       *//* map.put("code","user.notexist");
        map.put("message","");*//*
        //转发到/error
        return "forward:/error";
    }*/

}
