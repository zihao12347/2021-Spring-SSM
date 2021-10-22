package com.itheima.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect//切面类
@Order(1)//@Order注解指定相同通知方法加载顺序
public class AOPAdviceTwo {
    @Before("com.itheima.aop.AOPAdvice.pt()")//配置前置通知，指定切入点
    public void before(){
        System.out.println("AOPAdviceTwo:前置before...");
    }
}
