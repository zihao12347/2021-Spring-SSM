package com.itheima.dao.impl;

import com.itheima.dao.AccountDao;
import org.springframework.beans.factory.InitializingBean;

/**
 * bean初始化操作
 *      InitializingBean接口，为每个bean初始化前进行操作
 */
public class AccountDaoImpl implements AccountDao, InitializingBean {

    public void save() {
        System.out.println("account dao running...");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("InitializingBean 接口实现bean初始化前的操作");
    }
}
