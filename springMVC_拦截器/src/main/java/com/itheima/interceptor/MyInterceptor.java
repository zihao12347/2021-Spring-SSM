package com.itheima.interceptor;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 自定义拦截器：对控制器方法进行的请求拦截
 *      实现HandlerInterceptor接口
 */
public class MyInterceptor implements HandlerInterceptor {
    /**
     *预处理：对handle处理器（也就是控制器）进行预处处理：在控制器的方法执行之前执行
     *      应用于：用户认证/权限校验，请求参数的格式处理，
     * @param request
     * @param response
     * @param handler   被调用的处理器对象（controller），本质是一个方法对象(controller的中方法)，对反射中的Method对象进行再次包装。
     * @return 放行：如果有下一个拦截器就执行下一个，如果该拦截器是拦截器链中的最后一个，那么就执行控制器中的方法。
     *      true：放行
     *      false：结束
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println(handler);
        System.out.println(handler.getClass());
        System.out.println("前置处理！");
        return true;//放行
    }

    /**
     * 后处理：对Handler处理器(控制器)进行后处理，在控制器方法执行完成之后，执行，在视图返回之前，执行
     *      通过用于：对请求响应再次处理
     * @param request
     * @param response
     * @param handler
     * @param modelAndView  模型视图对象，可以在控制器方法处理完成之后，再对数据模型和视图重新定义
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("后置处理！");
    }

    /**完成处理：在拦截器后处理方法执行完，执行。
     *      通常用于：对异常进行处理
     *
     * @param request
     * @param response
     * @param handler
     * @param ex 异常对象：可以拦截到发生的异常
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("完成处理！");
    }
}
