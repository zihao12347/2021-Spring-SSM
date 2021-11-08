package com.itheima.controller.interceptor;

import com.itheima.controller.results.ResponseResult;
import com.itheima.exception.BusinessException;
import com.itheima.exception.SystemException;
import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.xml.ws.http.HTTPException;

@Component
@RestControllerAdvice
public class ProjectAdvice {

    /**
     * 处理自定义的业务异常
     * @param e
     * @return 响应操作编码，和错误信息
     */
    @ExceptionHandler(BusinessException.class)
    public ResponseResult doBusinessException(BusinessException e){
        System.out.println(e.getMessage());
        return new ResponseResult(e.getCode(),e.getMessage());
    }

    /**
     * 处理自定义的系统异常
     * @param e
     */
    @ExceptionHandler(SystemException.class)
    public void doSystemException(Exception e){
        System.out.println(e.getMessage());
    }

}
