package com.itheima.service;

import com.github.pagehelper.PageInfo;
import com.itheima.domain.User;

import java.util.List;

public interface UserServivce {
    public boolean save(User user);
    public boolean update(User user);
    public boolean delete(Integer uuid);
    public User get(Integer uuid);
    public PageInfo<User> getAll(int page, int size);
    public User login(String username,String password);
}
