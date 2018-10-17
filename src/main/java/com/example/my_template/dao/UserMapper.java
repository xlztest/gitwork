package com.example.my_template.dao;

import com.example.my_template.entity.Access_token;
import com.example.my_template.entity.Fromid;
import com.example.my_template.entity.Total;
import com.example.my_template.entity.Uv;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface UserMapper {

    public Access_token gettoken();

    public List<Fromid> getfromid();

    public int setstatus();

    public int setstatuszl();

    public List<Total> selectAll(@Param("time") String time);

    public int settoken(@Param("token") String token);

    public List<Total> selectzlAll(@Param("time")String time);

    public List<Uv> selectzlUV(@Param("time")String time);

}
