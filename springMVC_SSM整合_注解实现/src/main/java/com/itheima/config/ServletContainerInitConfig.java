package com.itheima.config;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractDispatcherServletInitializer;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import java.util.EnumSet;

public class ServletContainerInitConfig extends AbstractDispatcherServletInitializer {
    /**
     * 解决中文乱码
     * @param servletContext
     * @throws ServletException
     */
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        super.onStartup(servletContext);
        //创建字符集编码对象
        CharacterEncodingFilter filter = new CharacterEncodingFilter();
        filter.setEncoding("UTF-8");//设置utf-8编码
        FilterRegistration.Dynamic characterEncodingFilter = servletContext.addFilter("characterEncodingFilter", filter);//设置UTF-8编码过滤器
        characterEncodingFilter.addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST,
                DispatcherType.FORWARD,
                DispatcherType.INCLUDE,
                DispatcherType.ERROR,
                DispatcherType.ERROR
        ), false, "/*");//设置过滤器拦截所有请求
    }

    /**
     * 创建web上下文对象方法：加载springmvc的配置类，初始化SpringMVC应用上下文对象
     * @return
     */
    protected WebApplicationContext createServletApplicationContext() {
        AnnotationConfigWebApplicationContext webApplicationContext = new AnnotationConfigWebApplicationContext();
        webApplicationContext.register(SpringMvcConfig.class);//注册springMVC配置文件
        return webApplicationContext;
    }
    /**
     * 设置（diapacherServlet前端控制）拦截过滤所有请求
     * @return
     */
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    /**
     * 创建spring上下文对象方法，加载spring配置文件，初始化spring应用上下文镀锡
     * @return
     */
    protected WebApplicationContext createRootApplicationContext() {
        AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext();
        applicationContext.register(SpringConfig.class);//注册spring配置文件
        return applicationContext;
    }
}
