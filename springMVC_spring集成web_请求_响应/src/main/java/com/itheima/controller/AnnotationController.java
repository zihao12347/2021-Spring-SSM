package com.itheima.controller;

import com.itheima.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 请求中常用的注解
 *      @RequestParam注解：把请求中指定名称的参数的值赋值给控制器方法的形参，可以解决请参数名称和方法形参名称不一致的问题
 *            value/name属性：指定请求参数的名称
 *            required属性：指定是否必须包含该属性
 *            defaultValue属性：请求参数的默认指定
 *
 *      @RequstBody注解：用于获取请求体中的内容,get请求方式不适合
 *           required属性：是否必须有请求体
 *
 *      @PathAvailable注解：
 *
 */
@Controller
@RequestMapping("/anno")
public class AnnotationController {
    /**
     * 测试@RequestParam注解：
     * @return
     */
    @RequestMapping("/testRequestParam")
    public String testRequestParam(@RequestParam(name = "username") String name){
        System.out.println(name);
        return "/success.jsp";
    }

    /**
     * @RequestBody注解：用于获取请求体中的内容
     * @param user
     * @return
     */
    @RequestMapping("testRequestBody")
    public String testRequestBody(@RequestBody User user){
        System.out.println(user);
        return "/success.jsp";
    }
}
