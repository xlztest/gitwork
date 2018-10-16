package com.example.my_template.Service;


import com.example.my_template.dao.UserMapper;
import com.example.my_template.entity.Access_token;
import com.example.my_template.entity.Fromid;
import com.example.my_template.entity.Total;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{


    @Autowired
    private UserMapper userMapper;

    @Override
    public Access_token gettoken() {
        return userMapper.gettoken();
    }

    @Override
    public List<Fromid> getfromid() {
        return userMapper.getfromid();
    }

    @Override
    public int setstatus() {
        return userMapper.setstatus();
    }

    @Override
    public int settoken(String token) {
        return userMapper.settoken(token);
    }

    @Override
    public List<Total> selectAll(String time) {
        return userMapper.selectAll(time);
    }
}
