package com.itheima.controller;

import com.itheima.domain.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
public class EmployeeController {

    /**
     * 校验添加的员工信息
     * @param employee
     * @param errors  由spring框架提供的校验对象，获取校验失败的错误信息
     * @return
     */
    @RequestMapping("/addemployee")
    public String addEmployee(@Valid Employee employee,Errors errors,Model model){
        System.out.println(employee);
        System.out.println(errors.hasErrors());//hasErrors()方法获取是否有校验错误
        if (errors.hasErrors()) {//判断是否有校验错误
            //getFieldErrors()方法获取所有的错误校验字段对象
            List<FieldError> fieldErrors = errors.getFieldErrors();
            for (FieldError fieldError : fieldErrors) {
                System.out.println(fieldError.getField());//获取校验错误字段
                System.out.println(fieldError.getDefaultMessage());//获取校验错误提示信息
                model.addAttribute(fieldError.getField(), fieldError.getDefaultMessage());//将每个属性校验错误的属性和提示信息存储到request域中
            }
            return "addemployee.jsp";//当发送校验错误，还是转发到表单提交页面，并显示校验错误信息
        }
        System.out.println(employee);
        return "success.jsp";
    }

    /**
     * 分组校验添加的员工信息
     * @param employee
     * @param errors  由spring框架提供的校验对象，获取校验失败的错误信息
     * @return
     */
    @RequestMapping("/addemployee2")
    public String addEmployee2(@Validated({GroupA.class}) Employee employee,Errors errors,Model model){
        System.out.println(employee);
        System.out.println(errors.hasErrors());//hasErrors()方法获取是否有校验错误
        if (errors.hasErrors()) {//判断是否有校验错误
            //getFieldErrors()方法获取所有的错误校验字段对象
            List<FieldError> fieldErrors = errors.getFieldErrors();
            for (FieldError fieldError : fieldErrors) {
                System.out.println(fieldError.getField());//获取校验错误字段
                System.out.println(fieldError.getDefaultMessage());//获取校验错误提示信息
                model.addAttribute(fieldError.getField(), fieldError.getDefaultMessage());//将每个属性校验错误的属性和提示信息存储到request域中
            }
            return "addemployee.jsp";//当发送校验错误，还是转发到表单提交页面，并显示校验错误信息
        }
        System.out.println(employee);
        return "success.jsp";
    }

}
