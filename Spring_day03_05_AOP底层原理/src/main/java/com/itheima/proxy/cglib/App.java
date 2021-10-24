package com.itheima.proxy.cglib;

import com.itheima.proxy.cglib.dao.UserDao;
import com.itheima.proxy.jdk.JDKDinamicProxy;
import com.itheima.proxy.jdk.dao.impl.UserDaoImpl;

/**
 * 测试CGLIB动态代理:
 *      对于没有接口的情况,采用cglib动态代理技术,
 *      底层采用字节码技术,对目标类生成一个子类,对子类进行增强
 */
public class App {
    public static void main(String[] args) {
        UserDao userDao = new UserDao();//目标类
        CglibDynamicProxy cglibDynamicProxy = new CglibDynamicProxy();//代理对象
        //获取增强后的目标对象
        UserDao proxy =(UserDao) cglibDynamicProxy.createProxy(userDao);
        proxy.save();
    }
}
