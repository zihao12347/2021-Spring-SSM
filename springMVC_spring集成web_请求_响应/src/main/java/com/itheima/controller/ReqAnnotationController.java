package com.itheima.controller;

import com.itheima.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * 请求中常用的注解（4个常用@RequestParam @RequestBody @PathVariable @CookieValue）
 *
 *      *@RequestParam注解：把请求中指定名称的参数的值赋值给控制器方法的形参，可以解决请参数名称和方法形参名称不一致的问题 value/name属性：指定请求参数的名称
 *          required属性：指定是否必须包含该属性
 *          defaultValue属性：请求参数的默认指定
 *
 *      *@RequstBody注解：用于获取请求体中的内容,get请求方式不适合 required属性：是否必须有请求体
 *
 *      *@PathVariable注解：用于将url中的占位符绑定到方法的参数 eg: localhost:80/find/{uid}  {uid}就是占位符
 *
 *      *@CookieValue注解：把指定名称的cookie值绑定到方法的参数中
 *
 *
 *      @RequestHeader注解：用于获取请求头的信息
 *
 *      @ModelAttribute注解：作用于方法和参数上
 *            作用于普通方法上：表示当前方法，会在控制器的方法执行之前，先执行
 *            作用于参数上：获取指定的数据绑定到方法参数中
 *
 *
 */
@Controller
@RequestMapping("/req")
public class ReqAnnotationController {
    /**
     * 测试@RequestParam注解：
     *
     * @return
     */
    @RequestMapping("/testRequestParam")
    public String testRequestParam(@RequestParam(name = "username") String name) {
        System.out.println(name);
        return "/success.jsp";
    }

    /**
     * @param user
     * @return
     * @RequestBody注解：用于获取请求体中的内容
     */
    @RequestMapping("testRequestBody")
    public String testRequestBody(@RequestBody User user) {
        System.out.println(user);
        return "/success.jsp";
    }

    /**
     * @param name
     * @return
     * @PathVariable注解：用于将url的在占位符，绑定到方法的参数中
     */
    @RequestMapping("/testPathVariable/{name}")
    public String testPathVariable(@PathVariable(name = "name") String name) {
        System.out.println(name);
        return "/success.jsp";
    }

    /**
     * @RequestHeader注解：用于获取请求头的信息
     * @param header
     * @return
     */
    @RequestMapping("/testRequestHeader")
    public String testRequestHeader(@RequestHeader(name = "Accept") String header) {
        System.out.println(header);
        return "/success.jsp";
    }

    /**
     * 将指定名称的cookie值绑定到方法的参数中
     * @return
     */
    @RequestMapping("/testCookieValue")
    public String testCookieValue(@CookieValue(name = "JSESSIONID") String cookieValue){
        //获取JSESSIONID值
        System.out.println(cookieValue);
        return "/success.jsp";
    }

    @RequestMapping("/testModelAttribute")
    public String testModelAttribute(){
        System.out.println("控制器方法执行了！");
        return "/success.jsp";
    }

    /**
     * @ModelAttribute注解：作用在普通方法上，表示当前方法先于控制器方法执行
     */
    @ModelAttribute
    public void ModelAttribute(){
        System.out.println("ModelAttribute方法执行了");
    }



}
