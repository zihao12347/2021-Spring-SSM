package com.itheima.exception;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 自定义异常处理器:
 *          实现：HandlerExceptionResolver接口
 */

//@Component//装配到spring容器中
public class ExceptionResolver implements HandlerExceptionResolver {

    /**异常处理请求
     *
     * @param httpServletRequest
     * @param httpServletResponse
     * @param o
     * @param e 异常对象,捕获到的异常类型
     * @return ModelAndView模型视图对象，可以指定跳转的页面和响应的错误信息
     */
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        System.out.println(e);
        System.out.println(e.getClass());
        System.out.println("MyException is running......");
        ModelAndView modelAndView = new ModelAndView();
        /*if (e instanceof NullPointerException) {//当该异常对象为控制器异常类的实例，
            modelAndView.addObject("msg", "空指针异常！");//设置响应客户端错误信息

        }else */if (e instanceof ArithmeticException){//当异常类型为算数异常时
            modelAndView.addObject("msg", "算数异常！");
        }else {
            modelAndView.addObject("msg", "未知异常！");
        }
        modelAndView.setViewName("error.jsp");//设置异常跳转的错误页面
        return modelAndView;
    }
}
