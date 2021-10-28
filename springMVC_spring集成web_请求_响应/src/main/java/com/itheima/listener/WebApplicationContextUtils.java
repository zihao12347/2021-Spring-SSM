package com.itheima.listener;

import org.springframework.context.ApplicationContext;

import javax.servlet.ServletContext;

/**
 *封装一个获取spring应用上下文对象工具类
 */
public class WebApplicationContextUtils {
    public static ApplicationContext getWebApplicationContext(ServletContext servletContext){
        ApplicationContext applicationContext=(ApplicationContext) servletContext.getAttribute("app");
        return applicationContext;
    }
}
