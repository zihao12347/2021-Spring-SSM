package com.itheima.aop;

import com.itheima.dao.AccountDao;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import javax.sql.DataSource;

/**
 * 事务管理的切面类,定义环绕通知
 */
public class TxAdvice {

    //注入数据源
    private DataSource dataSource;
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    /**环绕通知:对转账操作进行一个事务管理
     * 1.创建事务管理器的实现类对象
     * 2.创建事务定义
     * 3.创建事务状态
     * 4.提交事务
     *
     * @return
     */
    public Object transactionManagement(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        //1.创建事务管理器实现类对象
        PlatformTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager(dataSource);
        //2.创建事务定义,事务默认的
        DefaultTransactionDefinition definition = new DefaultTransactionDefinition();
        //3.创建事务状态
        TransactionStatus transactionStatus = dataSourceTransactionManager.getTransaction(definition);
        //调用原始转账方法
        Object proceed = proceedingJoinPoint.proceed(proceedingJoinPoint.getArgs());
        //4.提交事务
        dataSourceTransactionManager.commit(transactionStatus);
        return proceed;
    }
}
