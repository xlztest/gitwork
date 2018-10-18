package com.example.my_template.Service.ServiceImpl;

import com.example.my_template.Service.ZlGameMapperService;
import com.example.my_template.dao.ZlGameMapper;
import com.example.my_template.entity.ZlGame;
import com.example.my_template.response.Result;
import com.example.my_template.response.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ZlGameMapperServiceImpl implements ZlGameMapperService {
    @Autowired
    private ZlGameMapper zlGameMapper;


    @Override
    public int insert(String game_name) {
        return zlGameMapper.insert(game_name);
    }

    @Override
    public ZlGame selectByPrimaryKey(String game_name) {
        return zlGameMapper.selectByPrimaryKey(game_name);
    }

    @Override
    public int updateByPrimaryKey(String game_name) {
        return zlGameMapper.updateByPrimaryKey(game_name);
    }

    @Override
    public List<ZlGame> selectAllclick() {
        return zlGameMapper.selectAllclick();
    }
}
