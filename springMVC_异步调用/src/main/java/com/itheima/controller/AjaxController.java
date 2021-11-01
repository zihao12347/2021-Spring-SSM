package com.itheima.controller;

import com.itheima.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class AjaxController {

//    @RequestMapping("/ajaxController")
//    public String ajaxController(){
//        System.out.println("ajax request is running...");
//        return "page.jsp";
//    }


    /**
     * @RequestBody注解，获取请求体中的内容
     * @param message
     * @return
     */
    @RequestMapping("/ajaxController")
    //使用@RequestBody注解，可以将请求体内容封装到指定参数中
    public String ajaxController(@RequestBody String message){//获取string类型的字符串内容
        System.out.println("ajax request is running..."+message);
        return "page.jsp";
    }

    @RequestMapping("/ajaxPojoToController")
    //如果处理参数是POJO，且页面发送的请求数据格式与POJO中的属性对应，@RequestBody注解可以自动映射对应请求数据到POJO中
    public String  ajaxPojoToController(@RequestBody User user){//获取请求体中内容，映射到pojo属性中
        System.out.println("controller pojo :"+user);
        return "page.jsp";
    }

    @RequestMapping("/ajaxListToController")
    public String  ajaxListToController(@RequestBody List<User> userList){//将请求体中的内容映射到集合参数中
        System.out.println("controller list :"+userList);
        return "page.jsp";
    }


    /**
     * @ResponseBody注解：响应json格式的数据给客户端
     * @return
     */
    @RequestMapping("/ajaxReturnString")
    public @ResponseBody String ajaxReturnString(){//响应String类型的json数据
        System.out.println("controller return string ...");
        return "page.jsp";
    }


    @RequestMapping("/ajaxReturnJson")
    @ResponseBody
    //基于jackon技术，使用@ResponseBody注解可以将返回的POJO对象转成json格式数据
    public User ajaxReturnJson(){
        System.out.println("controller return json pojo...");
        User user = new User();
        user.setName("Jockme");
        user.setAge(39);
        return user;//将对象解析成json格式的数据响应给客户端
    }

    @RequestMapping("/ajaxReturnJsonList")
    @ResponseBody
    public List ajaxReturnJsonList(){
        System.out.println("controller return json list...");
        User user1 = new User();
        user1.setName("Tom");
        user1.setAge(3);
        User user2 = new User();
        user2.setName("Jerry");
        user2.setAge(5);
        ArrayList al = new ArrayList();
        al.add(user1);
        al.add(user2);
        return al;//将集合解析成json格式的数据，响应给客户端
    }


    /**
     * 使用@CrossOrigin注解实现跨域访问
     * @param request
     * @return
     */
    @RequestMapping("/cross")
    @ResponseBody
    @CrossOrigin
    public User cross(HttpServletRequest request){
        System.out.println("controller cross..."+request.getRequestURL());//获取请求的url
        User user = new User();
        user.setName("Jockme");
        user.setAge(39);
        return user;
    }

}
