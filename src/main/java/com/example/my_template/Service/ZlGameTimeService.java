package com.example.my_template.Service;

import com.example.my_template.entity.ZlGameTime;


import java.util.List;

public interface ZlGameTimeService {

    int insert(String game_name,String time);

    ZlGameTime selectByPrimaryKey(String game_name);

    int updateByPrimaryKey(String game_name);

    int updateStatus();
    List<ZlGameTime> selectTime(String time);

}
