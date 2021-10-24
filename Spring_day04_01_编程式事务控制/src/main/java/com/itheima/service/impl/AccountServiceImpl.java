package com.itheima.service.impl;


import com.itheima.dao.AccountDao;
import com.itheima.service.AccountService;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import javax.sql.DataSource;

public class AccountServiceImpl implements AccountService {
    //注入dao
    private AccountDao accountDao;
    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }
    //注入数据源
    private DataSource dataSource;
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }


    /**账方法
     * 编程式的事务管理
     * @param outName     出账用户名
     * @param inName      入账用户名
     * @param money       转账金额
     */
    public void transfer(String outName, String inName, Double money) {
        //1.创建事务管理器实现类对象
        PlatformTransactionManager transactionManager = new DataSourceTransactionManager(dataSource);
        //2.创建事务定义,使用默认事务定义
        DefaultTransactionDefinition definition = new DefaultTransactionDefinition();
        //3.创建事务状态
        TransactionStatus transactionStatus = transactionManager.getTransaction(definition);
        accountDao.inMoney(outName,money);//减钱
        int i=1/0;//制造异常
        accountDao.outMoney(inName,money);//加钱
        //4.提交事务
        transactionManager.commit(transactionStatus);
    }

    /**
     * 转账方法
     *      声明式的事务管理:通过AOP技术实现
     * @param outName
     * @param inName
     * @param money
     */
    public void transferTwo(String outName, String inName, Double money){
        accountDao.inMoney(outName,money);//减钱
        int i=1/0;//制造异常
        accountDao.outMoney(inName,money);//加钱
    }
}
