package com.itheima.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.sun.org.apache.bcel.internal.generic.NEW;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Configuration
@Order(1)
public class JDBCConfig {
    /**
     * @Bean注解只能用在方法上，创建一个对象，并放入spring容器中
     * @return
     */
    @Bean
    public DruidDataSource druidDataSource(){
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setPassword("root");
        druidDataSource.setUsername("root");
        druidDataSource.setDriverClassName("com.mysql,jdbc.Driver");
        druidDataSource.setUrl("jdbc:mysql://localhost:3306/spring_db");
        return druidDataSource;
    }
    @Bean
    public String getConfig2(){
        System.out.println("config2");
        return "";
    }
}
