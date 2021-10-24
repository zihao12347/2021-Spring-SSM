package com.itheima;

/**
 * 切面类:定义各种通知
 */
public class Aspect {
    public void before(){//前置通知
        System.out.println("before");
    }

    public void after(){//后置通知
        System.out.println("after");
    }
}
