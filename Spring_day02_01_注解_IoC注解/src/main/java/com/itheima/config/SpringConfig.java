package com.itheima.config;

import org.springframework.context.annotation.*;
import org.springframework.core.annotation.Order;

@Configuration//@Configuration注解：表明该类是一个配置类，替代配置文件
@ComponentScan("com.itheima")//@ComponentScan注解，指定要扫描的包
@Import({JDBCConfig.class})//@Import注解导入其他配置类
@Order(2)
public class SpringConfig {
    @Bean
    public String getConfig1(){
        System.out.println("config1");
        return "";
    }
}
