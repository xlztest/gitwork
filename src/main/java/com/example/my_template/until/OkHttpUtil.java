package com.example.my_template.until;



import okhttp3.*;
import okhttp3.logging.HttpLoggingInterceptor;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author avanline
 * @descriotion
 * @date 2018-03-15 16:00
 */
public class OkHttpUtil {

    private static OkHttpUtil instance;

    private OkHttpClient okHttpClient = new OkHttpClient.Builder()
            .addNetworkInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.NONE))
            .connectTimeout(20, TimeUnit.SECONDS)
            .writeTimeout(20, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS)
            .addInterceptor(new RetryIntercepter(2))
            .build();

    public static OkHttpUtil getInstance() {
        if (instance == null) {
            synchronized (OkHttpUtil.class) {
                if (instance == null) {
                    instance = new OkHttpUtil();
                }
            }
        }
        return instance;
    }

    public void post(String json, String url, Callback callback) {
        //MediaType  设置Content-Type 标头中包含的媒体类型值
        RequestBody requestBody = FormBody.create(MediaType.parse("application/json; charset=utf-8"), json);
        Request request = new Request.Builder()
                .url(url)//请求的url
                .post(requestBody)
                .build();
        //创建/Call
        Call mCall = okHttpClient.newCall(request);
        mCall.enqueue(callback);
    }

    public Response post(String json, String url) throws IOException {
        RequestBody requestBody = FormBody.create(MediaType.parse("application/json; charset=utf-8"), json);
        Request request = new Request.Builder()
                .url(url)//请求的url
                .post(requestBody)
                .build();
        //创建/Call
        Call mCall = okHttpClient.newCall(request);
        return mCall.execute();
    }

    public Response get(Map<String, Object> map, String url) throws IOException {
        String urlNameString;
        if (map == null){
             urlNameString = url;
        }else {
             urlNameString = url + "?" + getUrlParamsFromMap(map);
        }
        Request request = new Request.Builder()
                .url(urlNameString)
                .get()
                .build();

            Call call = okHttpClient.newCall(request);
            return call.execute();

    }

    public Response get( String url) throws IOException {

        String urlNameString = url;

        Request request = new Request.Builder()
                .url(urlNameString)
                .get()
                .build();

        Call call = okHttpClient.newCall(request);
        return call.execute();

    }

    public Response get(Map<String, Object> map, String url, String cookie) throws IOException {
        String urlNameString = url + "?" + getUrlParamsFromMap(map);
        Request request = new Request.Builder()
                .url(urlNameString)
                .header("cookie", cookie)
                .get()
                .build();
        Call call = okHttpClient.newCall(request);
        return call.execute();

    }

    public void get(Map<String, Object> map, String url, String cookie, Callback callback) {
        String urlNameString = url + "?" + getUrlParamsFromMap(map);
        final Request request = new Request.Builder()
                .header("cookie", cookie)
                .url(urlNameString)//请求的url
                .get()//设置请求方式，get()/post()  查看Builder()方法知，在构建时默认设置请求方式为GET
                .build(); //构建一个请求Request对象

        //创建/Call
        Call call = okHttpClient.newCall(request);
        //加入队列 异步操作
        call.enqueue(callback);
    }

    public void get(Map<String, Object> map, String url, Callback callback) {
        String urlNameString = url + "?" + getUrlParamsFromMap(map);
        final Request request = new Request.Builder()
                .url(urlNameString)//请求的url
                .get()//设置请求方式，get()/post()  查看Builder()方法知，在构建时默认设置请求方式为GET
                .build(); //构建一个请求Request对象

        //创建/Call
        Call call = okHttpClient.newCall(request);
        //加入队列 异步操作
        call.enqueue(callback);
    }

    /**
     * description:将map转换成url参数格式: name1=value1&name2=value2
     *
     * @param map
     * @return
     */
    private String getUrlParamsFromMap(Map<String, Object> map) {
        try {
            if (null != map) {
                StringBuilder stringBuilder = new StringBuilder();
                for (Map.Entry<String, Object> entry : map.entrySet()) {
                    stringBuilder.append(entry.getKey()).append("=")
                            .append(entry.getValue()).append("&");
                }
                String content = stringBuilder.toString();
                if (content.endsWith("&")) {
                    content = TextUtils.substringBeforeLast(content, "&");
                }
                return content;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }


}
