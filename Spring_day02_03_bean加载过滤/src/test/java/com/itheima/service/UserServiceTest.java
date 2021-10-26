package com.itheima.service;

import com.itheima.dao.AccountDao;
import com.itheima.dao.BookDao;
import config.SpringConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)//加载配置类，初始化容器
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Autowired
    private BookDao bookDao;
    @Autowired
    private AccountDao accountDao;

    @Test
    public void testSave(){
        userService.save();
        bookDao.save();
        accountDao.save();
    }

}
