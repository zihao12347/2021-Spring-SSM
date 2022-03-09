package com.itheima.dao;

import com.github.pagehelper.Page;
import com.itheima.domain.User;

import java.util.List;

public interface UserMapper {
    public Page<User> findAll();



}
