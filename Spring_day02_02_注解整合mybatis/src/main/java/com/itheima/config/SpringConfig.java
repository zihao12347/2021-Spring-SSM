package com.itheima.config;

import org.apache.ibatis.annotations.Insert;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;


@Configuration//配置类
@ComponentScan("com.itheima")//开启注解扫描
@PropertySource("classpath:jdbc.properties")//导入外部配置文件
@Import({JDBCConfig.class,MybatisConfig.class})//导入外部的配置类
public class SpringConfig {


}
