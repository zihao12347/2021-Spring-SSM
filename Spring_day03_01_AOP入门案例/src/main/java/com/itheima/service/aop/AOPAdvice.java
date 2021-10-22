package com.itheima.service.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

/**
 * 二：编写通知类，
 */
public class AOPAdvice {

    /**获取原始方法中的方法参数
     *
     * @param joinPoint 连接点：原始方法
     */
    public void before(JoinPoint joinPoint){//前置通知
        Object[] args = joinPoint.getArgs();//获取原始方法中的方法参数
        System.out.println("before！"+args[0]);
    }

    public void after(){//后置通知
        System.out.println("after！");
    }

    public void afterReturn(){
        System.out.println("afterReturn!");
    }

    /**
     *  获取原始方法参数
     * @param proceedingJoinPoint 环绕通知方法的参数，可以调用原始方法
     * @throws Throwable
     */
    public void around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("around-before");
        Object ret = proceedingJoinPoint.proceed();//调用原始方法
        Object[] args = proceedingJoinPoint.getArgs();
        System.out.println("around-after"+"参数"+args[0]);
    }

    public void throwing(){
        System.out.println("Exception！");
    }



    /**
     * 获取原始方法中的返回值：在后置返回方法中
     * @param ret 返回值名称，返回值类型Object，因为不知道返回值是什么类型的
     */
    public void afterReturnTwo(Object ret){
        System.out.println("afterReturn!"+ret);
    }

    /**
     * 获取原始方法的返回值：在环绕方法中
     * @param proceedingJoinPoint
     */
    public Object aroundTwo(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("around-before");
        Object ret = proceedingJoinPoint.proceed();
        System.out.println(ret);
        System.out.println("around-after");
        return ret;
    }

    /**
     * 获取原始方法的异常--在异常通知中获取
     */
    public void ThrowingTwo(Throwable t){
        System.out.println("ThrowingTwo"+t.getMessage());
    }

    /**
     * 获取原始方法的异常--在环绕通知中获取
     */
    public void AroundThree(ProceedingJoinPoint proceedingJoinPoint) {//直接抛出异常
        System.out.println("before---around");
        try {
            proceedingJoinPoint.proceed();
        } catch (Throwable throwable) {//处理原始方法中的异常
            System.out.println("around---exception"+throwable.getMessage());
        }
        System.out.println("before---around");
    }

}
