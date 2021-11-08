package com.itheima.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.itheima.dao.UserDao;
import com.itheima.domain.User;
import com.itheima.service.UserServivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserServivce {
    @Autowired
    private UserDao userDao;//注入dao


    public boolean save(User user) {
        return  this.userDao.save(user);

    }

    public boolean update(User user) {
        return this.userDao.update(user);
    }

    public boolean delete(Integer uuid) {
        return this.userDao.delete(uuid);
    }

    public User get(Integer uuid) {
        return this.userDao.get(uuid);
    }


    public PageInfo<User> getAll(int page, int size) {
        PageHelper.offsetPage(page, size);
        List<User> userList = this.userDao.getAll();
        PageInfo<User> userPageInfo = new PageInfo<>(userList);
        return userPageInfo;
    }

    public User login(String username, String password) {
        return this.userDao.getByUsernameAndPassword(username,password);
    }
}
