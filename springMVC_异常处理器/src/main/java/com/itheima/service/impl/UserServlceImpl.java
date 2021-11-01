package com.itheima.service.impl;

import com.itheima.exception.bu.SystemException;

import java.sql.SQLException;

/**
 * 抛出自定义异常
 */
public class UserServlceImpl {
    public void save(){

        //业务层模拟异常，使用try.catch处理；
        try {
            throw new SQLException();
        } catch (SQLException e) {
            throw new SystemException("数据库连接超时！",e);//将出现的异常包装成自定义异常，并传入异常对象
        }
    }
}
