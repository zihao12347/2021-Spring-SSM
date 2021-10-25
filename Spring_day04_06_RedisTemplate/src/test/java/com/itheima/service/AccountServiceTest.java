package com.itheima.service;

import com.itheima.config.SpringConfig;
import com.itheima.domain.Account;
import com.itheima.service.impl.AccountServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import redis.clients.jedis.Jedis;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
//设定加载的spring上下文对应的配置
@ContextConfiguration(classes = SpringConfig.class)
public class AccountServiceTest {
    @Autowired
    private AccountServiceImpl accountService;
    /**
     * 测试Jedis操作redis数据库
     */
    @Test
    public void test(){
        Jedis jedis = new Jedis("172.245.34.184", 6379);
        jedis.set("name", "梓浩");

        System.out.println(jedis.get("name"));
    }

    @Test
    public void save(){
        Account account = new Account();
        account.setName("Jock");
        account.setMoney(666.66);

    }

    @Test
    public void changeMoney() {
        accountService.changeMoney(1, 1000d);

    }

    @Test
    public void findMondyById() {
        Double money = accountService.findMondyById(1);
        System.out.println(money);
    }
}