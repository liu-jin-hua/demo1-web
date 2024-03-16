package com.niubi.demo1;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/header")
public class TestHttpHeader extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.service(req, resp);
        // 获取请求头相关信息
        System.out.println(req.getMethod());
        System.out.println(req.getScheme());
        System.out.println(req.getProtocol());
        System.out.println(req.getRequestURI());
        System.out.println(req.getRequestURL());
        System.out.println(req.getLocalPort());
        System.out.println(req.getRemotePort());
        System.out.println(req.getServerPort());
        System.out.println(req.getHeader("Accept"));

        // 获取请求参数的API
        System.out.println(req.getParameter("hobby"));
        System.out.println(req.getParameter("youshi"));
    }


}
