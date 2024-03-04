package com.zcw.springboot07filter.web;

import javax.servlet.*;
import java.io.IOException;


/**
 * 过滤器
 */
public class MyFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse
            , FilterChain filterChain) throws IOException, ServletException {
        System.out.println("使用了 Servlet 中的 Filter 对象");
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
