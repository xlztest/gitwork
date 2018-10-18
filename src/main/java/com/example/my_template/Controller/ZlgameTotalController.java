package com.example.my_template.Controller;

import com.example.my_template.Service.ZlGameMapperService;
import com.example.my_template.Service.ZlGameTimeService;
import com.example.my_template.entity.ZlGame;
import com.example.my_template.entity.ZlGameTime;
import com.example.my_template.response.Result;
import com.example.my_template.response.ResultUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Slf4j
@RestController
public class ZlgameTotalController extends BaseController{
    @Autowired
    private ZlGameMapperService zlGameMapperService;
    @Autowired
    private ZlGameTimeService zlGameTimeService;

    @PostMapping("setGameName")
    public Result click_total(@Param("game_name")String game_name){
        response.setHeader("Access-Control-Allow-Origin", "*");
        ZlGame data= zlGameMapperService.selectByPrimaryKey(game_name);
        if(data==null){
          zlGameMapperService.insert(game_name);

        }else {
            zlGameMapperService.updateByPrimaryKey(game_name);
        }
       ZlGameTime zlGameTime=zlGameTimeService.selectByPrimaryKey(game_name);
       if(zlGameTime==null){
           Date day = new Date();
           SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
           String time = df.format(day);
           zlGameTimeService.insert(game_name,time);
       }else {
           zlGameTimeService.updateByPrimaryKey(game_name);
       }
        return ResultUtil.success();
    }

   @PostMapping("getGameName")
    public Result getAllclick(@Param("page")int page,@Param("rows")int rows,@Param("time")String time){
        response.setHeader("Access-Control-Allow-Origin", "*");
        PageHelper.startPage(page, rows);
        if(time==null) {
            List<ZlGame> clickList = zlGameMapperService.selectAllclick();
            PageInfo<ZlGame> newsListPageInfo = new PageInfo<>(clickList);
            return ResultUtil.success(newsListPageInfo);
        }
            List<ZlGameTime> clickList =zlGameTimeService.selectTime(time);
            PageInfo<ZlGameTime> newsListPageInfo = new PageInfo<>(clickList);
            return ResultUtil.success(newsListPageInfo);
    }


}
