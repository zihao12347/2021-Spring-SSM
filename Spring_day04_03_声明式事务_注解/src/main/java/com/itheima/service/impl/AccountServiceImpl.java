package com.itheima.service.impl;


import com.itheima.dao.AccountDao;
import com.itheima.domain.Account;
import com.itheima.service.AccountService;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.List;

public class AccountServiceImpl implements AccountService {

    private AccountDao accountDao;
    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Transactional(
            timeout = -1,
            isolation = Isolation.DEFAULT,
            readOnly = false,
            rollbackFor ={java.lang.ArithmeticException.class, IOException.class}
    )
    public void transfer(String outName, String inName, Double money) {
        accountDao.inMoney(outName,money);
        int i = 1/0;
        accountDao.outMoney(inName,money);
    }

}
