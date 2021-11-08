package com.itheima.config;

import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackages = "com.itheima",
        excludeFilters = @ComponentScan.Filter(
                type = FilterType.ANNOTATION,
                classes = Controller.class
        )
)//排除扫描controller组件
@EnableTransactionManagement//开启事务支持
@PropertySource("classpath:jdbc.properties")
@Import({MybatisConfig.class,SpringMvcConfig.class,JDBCConfig.class})
public class SpringConfig {

        /**
         * 配置平台事务管理器组件
         * @param dataSource
         * @return
         */
        @Bean
        public DataSourceTransactionManager transactionManager(@Autowired DataSource dataSource){
                DataSourceTransactionManager transactionManager = new DataSourceTransactionManager(dataSource);
                return transactionManager;
        }

}
