package com.itheima.dao;

import com.itheima.domain.User;

import java.util.List;

public interface UserMapper {
    public List<User> findAll();
    public User findById(Integer id);

    /**
     * 查询用户信息，并且包含用户下的账户信息：一对多查询
     * @return
     */
    public List<User> findUserAndAccount();


    public List<User> findByRid(Integer rid);
}
