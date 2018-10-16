package com.example.my_template.filter;

import com.example.my_template.enums.ResultEnum;
import com.example.my_template.response.ResultUtil;
import com.example.my_template.until.TextUtils;
import com.google.gson.Gson;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.EnumUtils;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Slf4j
public class LoginFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        String userId = request.getParameter("name");

        log.info("userId:{}",userId);
        if (!TextUtils.isEmpty(userId)){
                filterChain.doFilter(request, response);
        }else {
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/json; charset=utf-8");
            PrintWriter out;
            try{
                out = response.getWriter();
                out.append(new Gson().toJson(ResultUtil.error(ResultEnum.LOGIN)));
            }
            catch (Exception e){
                e.printStackTrace();
                response.sendError(500);
            }
        }
    }

    @Override
    public void destroy() {

    }
}