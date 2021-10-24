package com.itheima.proxy.jdk;

import com.itheima.proxy.jdk.dao.UserDao;
import com.itheima.proxy.jdk.dao.impl.UserDaoImpl;
import com.itheima.proxy.jdk.JDKDinamicProxy;
/**
 * 测试JDK动态代理:
 *      必须拥有一个接口
 */
public class App {
    public static void main(String[] args) {
        UserDao userDao = new UserDaoImpl();//目标对象(被代理对象)
        JDKDinamicProxy proxy = new JDKDinamicProxy();//代理对象
        //通过代理对象的createProxy()方法,创建增强后的目标对象
        UserDao userDaoAdvice = (UserDao) proxy.createProxy(userDao);
        userDaoAdvice.save();
    }
}
