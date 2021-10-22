package com.itheima.test;

import com.itheima.config.SpringConfig;
import com.itheima.domain.Account;
import com.itheima.service.impl.AccountServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * spring整合junit测试
 */
@RunWith(SpringJUnit4ClassRunner.class)//使用@RunWith()注解替换原有的运行器
@ContextConfiguration(classes = {SpringConfig.class})//使用@ContextConfiguration注解指定配置类
public class UserServiceTest {
    @Autowired
    private AccountServiceImpl accountService;
    @Test
    public void testFindById(){
        Account account = accountService.findById(1);
        /**
         * Assert工具类：通常用于程序测试时，用于来验证程序的准确性
         */
        Assert.assertEquals("Mike ", account.getName());

    }

}
