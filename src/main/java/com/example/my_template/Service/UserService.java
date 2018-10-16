package com.example.my_template.Service;

import com.example.my_template.entity.Access_token;
import com.example.my_template.entity.Fromid;
import com.example.my_template.entity.Total;

import java.util.List;


public interface UserService {

    public Access_token gettoken();

    public List<Fromid> getfromid();

    public int setstatus();

    public List<Total> selectAll(String time);

    public int settoken(String token);
}
