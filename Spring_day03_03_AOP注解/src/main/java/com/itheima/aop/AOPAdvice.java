package com.itheima.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
@Component
//2.1注解方式实现AOP通过@Aspect注解，表明当前类是一个切面类
@Aspect
public class AOPAdvice {

    //2.2定义切入点方法：
    @Pointcut("execution(* * ..*(..))")
    public void pt(){
    }


    @Before("pt()")//配置前置通知，指定切入点
    public void before(){
        System.out.println("前置before...");
    }

    @After("pt()")
    public void after(){
        System.out.println("后置after...");
    }


    @AfterReturning("pt()")
    public void afterReturing(){
        System.out.println("返回后afterReturing...");
    }


    @AfterThrowing("pt()")
    public void afterThrowing(){
        System.out.println("抛出异常后afterThrowing...");
    }


    @Around("pt()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("环绕前around before...");
        Object ret = pjp.proceed();
        System.out.println("环绕后around after...");
        return ret;
    }


    public void aop002exception(){
        System.out.println("前置before...2");
    }

}
