package com.niubi.demo1;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@WebServlet("/user")
public class UserHello extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("username");
        String info = "YES";
        ServletConfig servletConfig = this.getServletConfig();
        if("liujinhua".equals(name)){
            info = "<h1>No</h1>";
        }
        PrintWriter writer = resp.getWriter();
        writer.write(info);
        String param1 = servletConfig.getServletContext().getInitParameter("session");
        Enumeration<String> params = servletConfig.getServletContext().getInitParameterNames();
        while(params.hasMoreElements()){
            String param = params.nextElement();
            System.out.println(param);
        }
    }
}
