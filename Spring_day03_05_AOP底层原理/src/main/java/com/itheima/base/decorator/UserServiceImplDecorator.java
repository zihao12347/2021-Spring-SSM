package com.itheima.base.decorator;

import com.itheima.service.UserService;

public class UserServiceImplDecorator implements UserService {
    private UserService userService;

    public UserServiceImplDecorator(UserService userService) {
        this.userService=userService;
    }

    public void save() {
            userService.save();
            //增强功能：
        System.out.println("装饰者模式！进行增强");
    }
}
