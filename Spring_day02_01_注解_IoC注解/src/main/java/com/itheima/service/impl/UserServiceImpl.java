package com.itheima.service.impl;

import com.itheima.dao.UserDao;
import com.itheima.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component("userService")
@Scope("singleton")//bean作用范围
@PropertySource("classpath:jdbc.properties")//导入外部配置文件
public class UserServiceImpl implements UserService {
    @Value("${jdbc.username}")
    private String username;
    @Value("${jdbc.password}")
    private String password;

    public UserServiceImpl() {
        System.out.println("service运行！");
    }

    @Autowired//自动按照类型注入引用类型
    private UserDao userDao;

    @Value("3")//@Value注解：注入注入基本类型和string类型
    private int num;

    public void setNum(int num) {
        this.num = num;
    }

    public void save() {
        System.out.println("user service running..."+num+username+password);
        userDao.save();
    }

    @PostConstruct//bean生命周期注解---指定初始化方法
    public void init(){
        System.out.println("user servier init...");
    }

    @PreDestroy//bean生命周期注解----指定销毁化方法
    public void destroy(){
        System.out.println("user servier destroy...");
    }

}
