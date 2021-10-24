package com.itheima.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration//配置类
@ComponentScan("com.itheima")//包扫描
//@EnableAspectJAutoProxy注解:设置当前类开启AOP注解支持
@EnableAspectJAutoProxy
public class SpringConfig {
}
