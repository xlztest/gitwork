package com.example.my_template.Controller;

import com.alibaba.fastjson.JSON;
import com.example.my_template.Service.RedisService;
import com.example.my_template.entity.Total;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;

@Slf4j
@RestController
public class DemoController {


    @Autowired
    private RedisService redisService ;


    @RequestMapping(value = "/test",method = RequestMethod.GET)
    public void demoTest() throws UnsupportedEncodingException {
        Total total=new Total();
        total.setTotal(11);
        total.setTime("aa");
        total.setLocation("xx");
        String demo=JSON.toJSONString(total);
        demo=new String(demo.getBytes("gbk"),"utf-8");
        //redisService.set("aa",demo);
        log.info((String) redisService.get("aa"));
    }

}
