package com.soyanga.firstServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

/**
 * @program: servletTest
 * @Description:
 * @Author: SOYANGA
 * @Create: 2019-03-30 17:05
 * @Version 1.0
 */
public class FirstServlet extends HttpServlet {
    /**
     * 默认执行的是get方式提交
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //像浏览器输出内容
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().write("当前系统时间是:" + new Date());

    }
}
