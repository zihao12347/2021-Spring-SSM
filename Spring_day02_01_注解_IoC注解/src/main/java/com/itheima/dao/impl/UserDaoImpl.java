package com.itheima.dao.impl;

import com.itheima.dao.UserDao;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

/**
 * @DependsOn注解：当前userDao需要依赖userService组件，被依赖的userService组件，会比当前的userDao组件先加载到容器中
 */
@Component("userDao")
@DependsOn("userService")
public class UserDaoImpl implements UserDao {
    public UserDaoImpl() {
        System.out.println("userdao运行！");
    }

    public void save() {
        System.out.println("user dao running...");
    }
}
