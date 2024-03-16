package com.niubi.demo1;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/ServletA")
public class ServletA extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.service(req, resp);

        System.out.println("这是请求A，服务端实现转发，客户端无感知");
//        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/ServletB");
//        requestDispatcher.forward(req, resp);

        // 最值得关注的是，这种服务器内部转发，是可以访问WEB-INF文件内容的，因为把中请求认定为服务器行为
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("WEB-INF/web.xml");
        requestDispatcher.forward(req, resp);
    }
}
