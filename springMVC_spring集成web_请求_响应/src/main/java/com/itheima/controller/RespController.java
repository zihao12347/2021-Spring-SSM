package com.itheima.controller;

import com.itheima.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * SpringMVC的响应数据和结果视图
 *    一：返回值分类
 *       void 没有返回值
 *       String类型：指定视图逻辑名，默认会转发到指定的视图中
 *       ModelAndView类型：可以指定转发逻辑视图名称，和返回数据
 *
 *
 *    二：转发和重定向：
 *          forward转发：当控制器方法返回值为String类型，默认转发到指定视图页面中
 *              return "/success.jsp" == return "forward:/success.jsp"
 *          redirect重定向:重定向到指定的视图页面中。 return "redirect:/success.jsp",
 *              *转发和重定向的区别：
 *                  1.请求次数不同，
 *                      转发只请求一次，
 *                      重定向最少请求两次
 *                  2.数据共享：
 *                      转发能够共享requst域中数据
 *                      重定向不能
 *                  3.发生行为不同：
 *                      转发是由服务的行为
 *                      重定向是客户端的行为
 *
 *     三：响应Json数据
 *          通过@ResponseBody注解，将返回对象封装成json数据，响应给客户端
 *
 */
@Controller
@RequestMapping("/resp")
public class RespController {

    /**
     * 无返回值
     */
    @RequestMapping("/void")
    public void testVoid(){
        System.out.println("testVoid方法执行！");

    }

    /**
     * String类型的返回值：指定逻辑视图的名称，默认会转发到指定的视图页面中
     */
    @RequestMapping("/testString")
    public String testString(){
        System.out.println("testString方法执行！");
        return "/success.jsp";
    }

    /**
     * 转发：当返回值为String时候，默认会转发到指定的逻辑视图中，也可以通过 "forward:" 标识需要转发到的逻辑视图中
     * @return
     */
    @RequestMapping("/testForward")
    public String testForward(){
        System.out.println("testForward方法执行！");
        return "forward:/success.jsp";
    }

    /**
     * 重定义：当返回值为String时，通过"redirect:"关键字标识，需要重定向到的逻辑视图中
     * @return
     */
    @RequestMapping("/testRedirect")
    public String testRedirect(){
        System.out.println("testRedirect方法执行！");
        return "redirect:/success.jsp";
    }

    /**
     * ModelAndView类型的返回值：可以指定转发的逻辑视图和响应的数据
     * @return
     */
    @RequestMapping("/testModelAndView")
    public ModelAndView testModelAndView(){
        System.out.println("testModelAndView方法执行！");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("success");//指定跳转逻辑视图
        modelAndView.addObject("name", "梓浩");//添加响应数据
        return modelAndView;
    }

    /** @ResponseBody注解：将返回对象转换成json格式的数据，响应给客户端
     *
     * @return
     */
    @RequestMapping("/testRequestBody")
    public @ResponseBody User testRequestBody(){
        User user = new User();
        user.setUsername("梓浩");
        user.setAge(21);
        return user;
    }


}
