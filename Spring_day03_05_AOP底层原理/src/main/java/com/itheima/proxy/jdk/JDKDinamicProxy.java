package com.itheima.proxy.jdk;

import com.itheima.Aspect;
import com.itheima.proxy.jdk.dao.UserDao;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * AOP实现方式一:
 *      通过jdk动态代理技术实现:基于接口实现动态代理
 */
public class JDKDinamicProxy {
    //引入目标对象
    private UserDao userDao;

    /**
     * 创建代理方法,返回代理对象
     * @param userDao 目标接口
     * @return
     */
    public Object createProxy(final UserDao userDao){
        this.userDao=userDao;
        //获取被代理对象的类加载器
        ClassLoader classLoader = userDao.getClass().getClassLoader();
        //获取被加载对象的实现接口信息
        Class<?>[] interfaces = userDao.getClass().getInterfaces();
        //代理的逻辑方法:
        InvocationHandler invocationHandler = new InvocationHandler() {
           public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
               Aspect aspect = new Aspect();//切面对象
               aspect.before();//前置通知方法
               Object invoke = method.invoke(userDao, args);//调用被代理对象的原始方法
               aspect.after();//后置通知
               return invoke;
            }
        };
        Object proxyInstance = Proxy.newProxyInstance(classLoader, interfaces, invocationHandler);
        return proxyInstance;//返回代理对象
    }
}
