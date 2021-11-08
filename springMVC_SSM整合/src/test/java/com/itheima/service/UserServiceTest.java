package com.itheima.service;


import com.github.pagehelper.PageInfo;
import com.itheima.domain.User;
import com.itheima.service.UserServivce;
import com.sun.corba.se.impl.oa.toa.TOA;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations ="classpath:applicationContext.xml")//注解方式实现加载配置文件，初始化spring容器
public class UserServiceTest {
    @Autowired
    private UserServivce userServivce;
    @Test
    public void testGetALL(){
        PageInfo<User> all = userServivce.getAll(1, 5);
        List<User> list = all.getList();
        list.forEach(System.out::println);
        long total = all.getTotal();
        System.out.println(total);
    }
    @Test
    public void testSave(){
        User user = new User();
        user.setUserName("Lucy");
        user.setPassword("root");
        user.setRealName("Lucy");
        user.setGender(0);
        user.setBirthday(new Date());
        userServivce.save(user);
    }

    @Test
    public void testDelete(){
        User user = new User();
        userServivce.delete(3);
    }

    @Test
    public void testUpdate(){
        User user = new User();
        user.setUuid(1);
        user.setUserName("Jockme");
        user.setPassword("root");
        user.setRealName("JockIsMe");
        user.setGender(1);
        user.setBirthday(new Date(333333000000L));
        userServivce.update(user);
    }

    @Test
    public void testGet(){
        User user = userServivce.get(2);
        System.out.println(user);
    }

    @Test
    public void testLogin(){
        User user = userServivce.login("Jock", "root");
        System.out.println(user);
    }
}
