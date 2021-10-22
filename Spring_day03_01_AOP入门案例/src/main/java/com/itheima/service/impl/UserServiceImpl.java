package com.itheima.service.impl;

import com.itheima.service.UserService;

public class UserServiceImpl implements UserService {

    public int update() {//有返回值
        System.out.println("user service update running...");
        return 100;
    }

    /**
     * 连接点：方法
     */
    public void save(int num){//定义参数
        //一.将共性功能抽取出来
        //System.out.println("共性功能!");
        System.out.println("user service save running..."+num);
    }

    public void delete() {
        System.out.println("user service delete running...");
        int i=1/0;//定义异常
    }
}
