package com.itheima.service.impl;


import com.itheima.domain.Account;
import com.itheima.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
@Service("accountService")
public class AccountServiceImpl implements AccountService {

    //注入redis模板对象
    @Autowired
    private RedisTemplate redisTemplate;

    public void save(Account account) {

    }

    //设置string值
    public void changeMoney(Integer id, Double money) {
        redisTemplate.opsForValue().set("account:id"+id,money);
    }
    //获取String值
    public Double findMondyById(Integer id) {
        Object o = redisTemplate.opsForValue().get("account:id"+id);
        Double ao = new Double(o.toString());
        return ao;
    }
}