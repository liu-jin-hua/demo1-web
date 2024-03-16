package com.niubi.demo1;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Enumeration;

@WebServlet("/servletContext")
public class ServletContext extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.service(req, resp);
        // 获取全局配置servletContext
        ServletConfig servletConfig = this.getServletConfig();
        String param1 = servletConfig.getServletContext().getInitParameter("session");
        Enumeration<String> params = servletConfig.getServletContext().getInitParameterNames();
        while(params.hasMoreElements()){
            String param = params.nextElement();
            System.out.println(param);
        }
        //servletContext获取当前项目真实地址的API
        String path = servletConfig.getServletContext().getRealPath("/upload");
        System.out.println(path);

        // 获取项目的上下文的路径
        String appPath = servletConfig.getServletContext().getContextPath();
        System.out.println(appPath);

        //设置全局变量servletContext
        servletConfig.getServletContext().setAttribute("session", "whoami");
        System.out.println("已经设置全局变量session的值");
    }
}
