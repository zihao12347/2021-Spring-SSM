package com.itheima.controller;

import com.itheima.pojo.User;
import com.itheima.service.UserService;
import com.itheima.web.UserServlet;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @Controller注解：表示当前类为一个控制器类，编写具体的业务控制器
 *
 * @RequestMapping注解：用于建立请求url和处理请求方法之间的对应关系，可以作用在类/方法上
 *      value/path属性：指定请求的url
 *      method属性：指定请求的方式
 *      params属性：限定请求参数的条件
 *
 * 请求参数的绑定：
 *      请求参数支持的数据类型：
 *          1.基本数据类型/String
 *          2.实体类型（JavaBean）
 *          3.集合数据类型（List/Map等）
 *        *特殊情况：
 *              请求每一个参数的值都是String类型的，是Springmvc帮我们自动转换成对应的int/double/boolean等类型的数据，
 *              有时也存在类型转换问题：string-data  springmvc默认支持转换的2021/10/27,如果日期参数的值为2021-10-27,
 *              就会出现类型转换的错误，此时可以自定义类型转换器；
 *         自定义全局请求参数类型转换器：
 *              1.编写转换器类，继承Convert<R,T>接口
 *              2.在spring-mvc.xml文件中配置自定义转换器:ConvertServiceFactoryBean
 *              3.在<mvc:annotation-driven>开启springmvc注解支持的标签中；中指定conversion-service属性的值
 *            *@DateTimeFormat()注解：实现日期类型的参数转化
 *
 *       4.使用原生的ServletAPI作为控制器方法的参数，
 *              1.HttpServletRequest
 *              2.HttpServletResponse
 *              3.HttpSession
 *       5.Model作用方法的参数：可以用于存储数据，存储的数据底层保存在request域对象中
 *              addAttribute()方法，
 *
 *
 *
 */
@Controller
@RequestMapping("/user")
public class UserController  {


    /**@RquestMapping注解：建立请求url和处理请求方法的对应关系
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
     * 测试将请求参数绑定实体类型中（javaBean）
     *
     * @return
     */
    @RequestMapping("/testParamTwo")
    public String testParamTwo(User user){
        System.out.println(user);
        return "/success.jsp";
    }

    /**
     * 测试自定义转换请求参数
     * @return
     */
    @RequestMapping("/testConvert")
    public String testConvert(User user){
        System.out.println(user);
        return "/success.jsp";
    }

    /**
     * 使用原生的ServletAPI作为方法的参数
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/testServletApi")
    public String testServletApi(HttpServletRequest request, HttpServletResponse response, HttpSession session){

        System.out.println(request);
        return "/success.jsp";
    }


    /**
     * 测试Model作方方法参数，可以用来存储数据，将数据保存在request域对象中
     * @param model
     * @return
     */
    @RequestMapping("/testModel")
    public String testModel(Model model){
        model.addAttribute("name", "梓浩");//存储数据，将数据存储在request域中
        System.out.println(model);
        return "/success.jsp";
    }


}
