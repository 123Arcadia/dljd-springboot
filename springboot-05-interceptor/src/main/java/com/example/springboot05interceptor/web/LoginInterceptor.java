package com.example.springboot05interceptor.web;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor implements HandlerInterceptor {
    /**
     *
     * @param request
     * @param response
     * @param handler 拦截器对象
     * @return
     *  true:改请求可以被Contoller处理
     *  false:请求被截断
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception {
        System.out.println("实现了LoginIterceptor的preHandle!");
        return false;
//        return true;
    }
}
