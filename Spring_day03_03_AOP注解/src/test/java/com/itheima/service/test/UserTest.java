package com.itheima.service.test;

import com.itheima.config.SpringConfig;
import com.itheima.service.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)//使用ContextConfiguration注解来加载配置类，初始化spring容器
public class UserTest {
    @Autowired
    private UserService userService;
    @Test
    public void testSave(){
        int save = userService.save(666, 888);
        Assert.assertEquals(100, save);
    }
}
