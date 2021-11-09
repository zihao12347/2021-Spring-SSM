package com.itheima.dao;

import com.itheima.domain.Account;

import java.util.List;

public interface AccountMapper {
    public List<Account> findAll();

    /**
     * 查询账户信息，并且包含账户下的用户信息，多对一查询
     * @return
     */
    public List<Account> findAccountAndUser();
}
