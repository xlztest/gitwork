package com.example.my_template.Service.ServiceImpl;

import com.example.my_template.Service.ZlGameTimeService;
import com.example.my_template.dao.ZlGameTimeMapper;
import com.example.my_template.entity.ZlGameTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ZlGameTimeServiceImpl implements ZlGameTimeService {

    @Autowired
   private ZlGameTimeMapper zlGameTimeMapper;

    @Override
    public int insert(String game_name,String time) {
        return zlGameTimeMapper.insert(game_name,time);
    }

    @Override
    public ZlGameTime selectByPrimaryKey(String game_name) {
        return zlGameTimeMapper.selectByPrimaryKey(game_name);
    }

    @Override
    public int updateByPrimaryKey(String game_name) {
        return zlGameTimeMapper.updateByPrimaryKey(game_name);
    }

    @Override
    public int updateStatus() {
        return zlGameTimeMapper.updateStatus();
    }

    @Override
    public List<ZlGameTime> selectTime(String time) {
        return zlGameTimeMapper.selectTime(time);
    }
}
