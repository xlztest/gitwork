package com.example.my_template.exception;

public class UserNoExistException extends  RuntimeException{

    public UserNoExistException(String msg) {
        super(msg);
    }
}
