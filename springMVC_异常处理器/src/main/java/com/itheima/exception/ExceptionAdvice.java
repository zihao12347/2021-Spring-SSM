package com.itheima.exception;

import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * SpringMVC注解开发异常处理器:
 * @ControllerAdvice注解：controller增强器，用于全局异常处理；类注解
 * @ExceptionHandler注解：方法注解，设置指定类型的异常处理方式
 *
 */
//@Component//装配到springmvc容器中
//@ControllerAdvice//controller增强器，用于全局异常处理
public class ExceptionAdvice {
    /**
     * 异常处理器方法：处理空指针异常
     */
    @ExceptionHandler(NullPointerException.class)//处理空指针异常
    @ResponseBody
    public String doNullExpction(Exception e){
        System.out.println("null exception....");
        return "空指针异常！";
    }

    /**
     * 异常处理器方法：处理算数异常
     * @return
     */
    @ExceptionHandler(ArithmeticException.class)
    @ResponseBody
    public ModelAndView doAritheticException(Exception e){
        System.out.println("arithmeticException ..."+e);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("msg", "算数异常！");//设置异常响应信息
        modelAndView.setViewName("error.jsp");//设置异常响应视图
        return modelAndView;
    }

    /**
     * 处理异常
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public String doException(Exception e){
        System.out.println("出现异常！"+e);
        return "error.jsp";
    }


}
