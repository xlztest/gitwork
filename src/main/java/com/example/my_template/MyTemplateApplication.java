package com.example.my_template;

import com.example.my_template.filter.LoginFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import javax.servlet.Filter;

@SpringBootApplication
public class MyTemplateApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyTemplateApplication.class, args);
    }


    //过滤器
    @Bean
    public FilterRegistrationBean filterRegistrationBean(){
        FilterRegistrationBean<Filter> filterRegistrationBean = new FilterRegistrationBean<>();
        LoginFilter mLoginFilter = new LoginFilter();   //new过滤器
        filterRegistrationBean.setFilter(mLoginFilter);       //set
        filterRegistrationBean.addUrlPatterns("/hello");    //set
        filterRegistrationBean.setOrder(1);
        return filterRegistrationBean;
    }

}
