package com.zcw.springboot06servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * ServletRegistrationBean 用来做在 servlet 3.0+容器中注册 servlet 的功能，但更具有
 * SpringBean 友好性。
 * 实现步骤：
 *  1. 创建 Servlet
 */
public class MyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp);
        resp.setContentType("text/html;charset=utf-8");
        /**
         * "html/text"反过来会下载一个文件
         */
        PrintWriter out = resp.getWriter();
        out.println("使用Servlet对象!");
        System.out.println("-------");
        out.flush();
        out.close();
    }
}
