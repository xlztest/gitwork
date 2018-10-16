package com.example.my_template.Controller;

import com.alibaba.fastjson.JSON;
import com.example.my_template.Service.UserService;
import com.example.my_template.entity.Access_token;
import com.example.my_template.entity.Fromid;
import com.example.my_template.entity.Muban;
import com.example.my_template.until.OkHttpUtil;
import com.example.my_template.exception.UserNoExistException;
import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONObject;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Configuration
@EnableScheduling
@Controller
public class sendController {

    @Autowired
    private UserService userService;

    //@Scheduled(cron="0 0 20 * * ?")
    @Scheduled(cron="0 0 20 * * ?")
    public void taketemplate() throws IOException {
        //Access_token access_token= userService.gettoken();

        //小程序appid
        String APPID = "wx151c5e6fee571012";
        //小程序密码
        String APPSECRET = "bfcba22c61e2e0d55a9dba86a0629f7f";
        //获取access_token
        String ACCESS_TOKEN="https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";
        String url1=ACCESS_TOKEN.replace("APPID", APPID).replace("APPSECRET", APPSECRET);
        OkHttpUtil okHttpUtil =new OkHttpUtil();
        Response response= okHttpUtil.get(url1);
        String data1 =  response.body().string();
        JSONObject mJSONObject = JSONObject.fromObject(data1);
        String access_token= mJSONObject.getString("access_token");

        List<Fromid> fromids=userService.getfromid();

        for(int i=0;i<fromids.size();i++){

        //OkHttpUtil okHttpUtil =new OkHttpUtil();
        String url="https://api.weixin.qq.com/cgi-bin/message/wxopen/template/send?access_token="+access_token;

        Map<String, Object> data=new LinkedHashMap<String, Object>();

        LinkedHashMap<String,String> first =new LinkedHashMap<String,String>();

        first.put("value","恭喜你获得免费抽取iphone的机会，10分钟后过期！");

        data.put("keyword1",first);

        LinkedHashMap<String,String>account=new LinkedHashMap<String,String>();

        account.put("value","积分、红包大放送");

        data.put("keyword2",account);
        Muban muban=new Muban();
        muban.setTouser(fromids.get(i).getOpenid());
        muban.setTemplate_id("Xlq26hrF11FUbXMTM_kwc4GxY-nwWOFVwDnkgfLf0oE");
        muban.setPage("pages/index/index");
        muban.setForm_id(fromids.get(i).getFrom_id());
        muban.setData(data);
        String aa=JSON.toJSONString(muban);

        okHttpUtil.post(aa, url, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
              String data =  response.body().string();
                log.info(data);
            }
        });
        }
    }

    @Scheduled(cron="0 0 0 * * ?")
    public void setstatus(){

        userService.setstatus();


}

   /* @Scheduled(cron="0 0 19 * * ?")
    public void settoken() throws IOException {
        //小程序appid
         String APPID = "wx151c5e6fee571012";
        //小程序密码
         String APPSECRET = "bfcba22c61e2e0d55a9dba86a0629f7f";
        //获取access_token
         String ACCESS_TOKEN="https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";
        String url=ACCESS_TOKEN.replace("APPID", APPID).replace("APPSECRET", APPSECRET);
        OkHttpUtil okHttpUtil =new OkHttpUtil();
        Response response= okHttpUtil.get(url);
        String data =  response.body().string();
        JSONObject mJSONObject = JSONObject.fromObject(data);
        String access_token= mJSONObject.getString("access_token");
        userService.settoken(access_token);
        log.info(access_token);
    }*/

    @ResponseBody
    @GetMapping("/hello")
    public String hello(@RequestParam("user") String user){
        if(user.equals("aa")){
            throw  new UserNoExistException("用户不存在！");
        }
        userService.getfromid();
        userService.getfromid();
        return "helloword";
    }





}
