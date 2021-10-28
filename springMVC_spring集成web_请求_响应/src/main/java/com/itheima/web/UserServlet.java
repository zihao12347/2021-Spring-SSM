package com.itheima.web;

import com.itheima.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import sun.net.www.http.HttpClient;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        ServletContext servletContext = req.getServletContext();//获取servlet应用上下文对象
        //通过自定义封装的工具类直接获取到存储的servletContext域中的applicationContext
        //ApplicationContext app = (ApplicationContext) WebApplicationContextUtils.getWebApplicationContext(servletContext);

        //通过spring框架提供的WebApplicaitonContextUtils工具类获取applicationContext对象
        ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
        UserService userService =(UserService) context.getBean(UserService.class);
        userService.save();
        System.out.println("Spring容器执行完毕！");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      this.doGet(req, resp);
    }
}
