package com.itheima.proxy.cglib;

import com.itheima.Aspect;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * CGLIB动态代理技术:
 *     采用非常底层字节码技术,对目标类生成一个子类,对子类进行增强
 */
public class CglibDynamicProxy {
    /**
     * 创建代理方法,返回CGLIB代理对象
     * @param target 目标类
     * @return
     */
    public Object createProxy(final Object target){
        //1.创建增强对象Enhancer
        Enhancer enhancer = new Enhancer();
        //2.确定需要增强的类(目标类),设置enhance的父类
        enhancer.setSuperclass(target.getClass());
        MethodInterceptor methodInterceptor = new MethodInterceptor() {
            /**
             * 代理的逻辑方法
             * @param o 生成的代理对象
             * @param method    拦截的方法
             * @param objects   拦截方法的参数
             * @param methodProxy   方法的代理对象,用于执行父类方法
             * @return
             * @throws Throwable
             */
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                Aspect aspect = new Aspect();
                aspect.before();//前置通知
                Object invoke = methodProxy.invoke(target, objects);//执行目标类的原始方法
                aspect.after();//后置通知
                return invoke;
            }
        };
        //3.设置代理逻辑方法
        enhancer.setCallback(methodInterceptor);
        //4.返回创建的代理对象
        return enhancer.create();
    }

}
