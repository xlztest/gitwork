package com.example.my_template.dao;

import com.example.my_template.entity.ZlGameTime;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface ZlGameTimeMapper {

    int insert(@Param("game_name") String game_name, @Param("time")String time);

    ZlGameTime selectByPrimaryKey(@Param("game_name")String game_name);

    int updateByPrimaryKey(@Param("game_name")String game_name);

    int updateStatus();

    List<ZlGameTime> selectTime(@Param("time")String time);
}