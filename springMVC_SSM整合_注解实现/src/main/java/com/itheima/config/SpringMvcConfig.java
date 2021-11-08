package com.itheima.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @EnableWebMvc注解：
 *      作用；
 *          1.支持ConversionService的配置，可以配置自定义转换器
 *          2.支持@NumberFormat注解，格式化数字类型
 *          3.支持@DateTimeFormat注解，格式化日期数字
 *          4.支持@Valid校验注解，jsr303实体类属性的校验
 *          5.提供注解读写xml和JSON格式数据
 *
 */
@ComponentScan("com.itheima.controller")
@EnableWebMvc//开启springmvc注解支持
public class SpringMvcConfig implements WebMvcConfigurer {

}
