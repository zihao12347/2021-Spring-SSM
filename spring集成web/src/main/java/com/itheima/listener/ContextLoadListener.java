package com.itheima.listener;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * 手动方式实现：Spring整合web环境，避免每次web层调用service都需要加载配置文件，初始化spring容器，获取bean组件
 *监听器功能：监听对象的创建，监听域中的属性变化，监听会话信息等
 * 通过ServletContextListener监听器，监听对象的创建，
 *      需要实现的功能：
 *      1.在web容器初始化时，加载配置文件，初始化spring容器
 *      2.将获取到的applicationcontext对象保存在servletcontext域中
 *
 */
public class ContextLoadListener implements ServletContextListener {
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        //加载配置文件，初始化spring容器
        //ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        //getServletContext()方法获取域对象
        ServletContext servletContext = servletContextEvent.getServletContext();
        String contextConfigLocation = servletContext.getInitParameter("contextConfigLocation");
        //获取全局初始化参数-配置了配置名称
        ApplicationContext context = new ClassPathXmlApplicationContext(contextConfigLocation);
        //2.将创建的applicationContext应用上下文对象保存在servletContext域中
        servletContext.setAttribute("app", context);//向域中存储spring应用上下文

    }

    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
