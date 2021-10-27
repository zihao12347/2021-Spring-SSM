package com.itheima.controller;

import com.itheima.pojo.User;
import com.itheima.service.UserService;
import com.itheima.web.UserServlet;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Controller注解：表示当前类为一个控制器类，编写具体的业务控制器
 *
 * @RequestMapping注解：用于建立请求url和处理请求方法之间的对应关系，可以作用在类和方法上
 *      value/path属性：指定请求的url
 *      method属性：指定请求的方式
 *      params属性：限定请求参数的条件
 *
 * @RequestParam注解： 将请求参数的值绑定到方法参数上
 *      value/name属性：指定请求参数名称
 *      required属性：指定是否必须有该请求参数
 *     *支持的数据类型：
 *          基本数据类型/String
 *          实体类型（JavaBean）
 *          集合数据类型（List/Map等）
 */
@Controller
@RequestMapping("/user")
public class UserController  {


    /**
     * 1.value属性：指定请求url
     * 2.method属性：指定请求方式
     * 3.params属性：限制请求参数的条件：
     * params = {"username"}:表示请求参数名必须是username
     * params = {"username=hh"}:表示请求参数为username,请求值为hh
     * 4.headers属性：限定请求头的条件，
     * headers = {"Accept"}：表示请求头中必须有Accept
     * @return
     */
    @RequestMapping(value = "/save",method = {RequestMethod.GET},params = {"username=hh"},headers = {"Accept"})
    public String save(){
        System.out.println("Controller save method is running!");
        return "/success.jsp";
    }


    /**
     * 将请求参数中的值绑定到控制器方法的参数中
     * 测试绑定String类的值
     * @param username
     * @return
     */
    @RequestMapping("testParam")
    public String testParamOne(@RequestParam(name = "username") String username){
        System.out.println(username);
        return "/success.jsp";
    }

    /**
     * @RequestParam注解：将请求中的参数值绑定到控制器方法中参数中
     * 测试将请求参数绑定实体类型中（javaBean）
     * @return
     */
    @RequestMapping("/testParamTwo")
    public String testParamTwo(User user){
        System.out.println(user);
        return "/success.jsp";
    }
}
