package com.example.my_template.dao;

import com.example.my_template.entity.Login;

public interface LoginMapper {
    int deleteByPrimaryKey(String token);

    int insert(Login record);

    int insertSelective(Login record);

    Login selectByPrimaryKey(String token);

    int updateByPrimaryKeySelective(Login record);

    int updateByPrimaryKey(Login record);
}