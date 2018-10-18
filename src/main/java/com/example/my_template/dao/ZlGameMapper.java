package com.example.my_template.dao;

import com.example.my_template.entity.ZlGame;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface ZlGameMapper {

    int insert(@Param("game_name") String game_name);

    ZlGame selectByPrimaryKey(@Param("game_name")String game_name);

    int updateByPrimaryKey(@Param("game_name")String game_name);

    List<ZlGame> selectAllclick();
}