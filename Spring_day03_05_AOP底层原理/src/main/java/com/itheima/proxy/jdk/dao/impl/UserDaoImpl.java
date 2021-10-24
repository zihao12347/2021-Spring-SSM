package com.itheima.proxy.jdk.dao.impl;

import com.itheima.proxy.jdk.dao.UserDao;

/**
 * 目标类
 */
public class UserDaoImpl implements UserDao {
    public void save() {
        System.out.println("userDao Save method!");
    }
}
