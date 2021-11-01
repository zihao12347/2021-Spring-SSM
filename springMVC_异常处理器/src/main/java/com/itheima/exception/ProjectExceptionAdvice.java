package com.itheima.exception;

import com.itheima.exception.bu.BusinessException;
import com.itheima.exception.bu.SystemException;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 使用自定义异常包装类，进行处理。
 */
@Component
@ControllerAdvice
public class ProjectExceptionAdvice {
    /**
     * 自定义业务异常处理
     * @return
     */
    @ExceptionHandler(BusinessException.class)
    public String doBusinessException(Exception e, Model model){
        model.addAttribute("msg", e.getMessage());//将异常消息保存在request中
        System.out.println(e.getMessage());
        return "error.jsp";
    }

    /**
     * 系统自定义异常的处理
     * @param e
     * @param model
     * @return
     */
    @ExceptionHandler(SystemException.class)
    public String doSystemException(Exception e,Model model){
        model.addAttribute("msg", "服务器出现问题，请联系管理员！");
        //实际的异常信息，应存储在redis中，供运维人员后台系统查看
        System.out.println(e.getMessage());
        return "error.jsp";
    }
}
