package com.example.my_template.Service;

import com.example.my_template.entity.ZlGame;
import com.example.my_template.response.Result;

import java.util.List;

public interface ZlGameMapperService {

    int insert(String game_name);

    ZlGame selectByPrimaryKey(String game_name);

    int updateByPrimaryKey(String game_name);

    List<ZlGame> selectAllclick();
}
