package com.itheima;

/**
 * SpringMVC----拦截器:
 *      springMVC的拦截器，类似于servlet中的filter过滤器，
 *      用于对处理器Handler（控制器）进行预处理和后处理, 用户可以自定义一下拦截器进行特殊的功能。
 *      核心原理：AOP技术实现，对目标方法进行增强。
 *    *过滤器和拦截器的区别
 *      归属不同：
 *           Filter属于Servlet技术，可以在任意java web工程中使用。
 *           Interceptor属性SpringMVC的技术，只适用与springmvc的框架工程。
 *      拦截内容不同：
 *          interceptor只是访问对控制器的方法进行拦截
 *          filter对所有的访问资源进行拦截
 *
 *     自定义拦截：
 *          1.实现HandleInterceptor接口
 *                  1.PreHandler(res,resp,O handler)方法：预处理方法
 *                  用于：权限验证，请求参数格式的处理
 *
 *                  2.PostHandler(res,resp,h,modelAndView)方法：后处理方法
 *                  用于：对请求响应再次封装
 *                  3.AfterCompletion(res,resp,h,m,exception)方法：完成处理方法
 *                  用于：对异常处理
 *
 *          2.在spring-mvc配置文件中，配置使用
 *
 *
 *
 */
public class App {
}
