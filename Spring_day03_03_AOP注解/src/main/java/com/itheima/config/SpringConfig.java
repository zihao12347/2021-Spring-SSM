package com.itheima.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration//配置类
@ComponentScan("com.itheima")//包扫描
@EnableAspectJAutoProxy
public class SpringConfig {
}
