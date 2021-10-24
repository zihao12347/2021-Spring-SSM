package com;


import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * AOP:
 *   AOP的实现方式：
 *      1.默认DK的动态代理：基于接口的动态代理
 *          必须用于一个接口,才是产生代理对象
 *
 *      2.Spring提供的CGLIB动态代理技术：基于父类的动态代理，
 *          对于没有接口的情况，只能采用CGLIB代理技术，采用非常底层的字节码技术，
 *          对目标对象生成一个子类，对子类进行增强
 *
 */
public class App {
    public static void main(String[] args) {

    }
}
