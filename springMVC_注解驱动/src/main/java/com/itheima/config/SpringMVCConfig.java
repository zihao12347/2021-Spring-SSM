package com.itheima.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * SpringMVC的配置类:
 *          实现WeMVCConfiguration接口，
 */
@Configuration//配置类注解
@ComponentScan(value = "com.itheima",includeFilters = @ComponentScan.Filter(
        type = FilterType.ANNOTATION,
        classes = Controller.class
))//bean的加载过滤，只扫描controller注解的类
public class SpringMVCConfig implements WebMvcConfigurer {

    /**
     * 注解实现静态资源不被dispatchservlet拦截，
     */

    /* 方式一：
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("").addResourceLocations();
    }*/

    //方式二：实现静态资源不拦截
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

}
