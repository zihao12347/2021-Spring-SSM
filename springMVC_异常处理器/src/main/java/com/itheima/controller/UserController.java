package com.itheima.controller;

import com.itheima.domain.User;
import com.itheima.exception.bu.SystemException;
import com.itheima.exception.bu.BusinessException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {
    @RequestMapping("/save")
    @ResponseBody
    public List<User> save(@RequestBody User user) {
        System.out.println("user controller save is running ...");

        //模拟产生异常
        //int i=1/0;
        //String s=null;
        //s.length();

        //抛出自定义的业务异常
        if (user.getName().trim().length()<8){
            throw new BusinessException("用户名长度不满足长度最少为8的条件！");//设置异常错误信息
        }
        if (user.getAge()<0){
            throw  new BusinessException("对不起，年龄不符合规格！");
        }
        //抛出自定义的系统异常
        if (user.getAge() > 100) {
            throw new SystemException("服务器连接失败！请及时检查处理！");
        }



        User u1 = new User();
        u1.setName("Tom");
        u1.setAge(3);
        User u2 = new User();
        u2.setName("Jerry");
        u2.setAge(5);
        ArrayList<User> al = new ArrayList<User>();
        al.add(u1);
        al.add(u2);

        return al;
    }
}
