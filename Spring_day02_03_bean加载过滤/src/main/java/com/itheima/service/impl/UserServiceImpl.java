package com.itheima.service.impl;


import com.itheima.dao.AccountDao;
import com.itheima.dao.BookDao;
import com.itheima.dao.EquipmentDao;
import com.itheima.dao.UserDao;
import com.itheima.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    public void save() {
        System.out.println("user service running...");
        userDao.save();

    }
}
