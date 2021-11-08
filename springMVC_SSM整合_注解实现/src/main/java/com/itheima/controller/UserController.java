package com.itheima.controller;

import com.github.pagehelper.PageInfo;
import com.itheima.controller.constant.ConstantMessage;
import com.itheima.controller.results.ResponseResult;
import com.itheima.domain.User;
import com.itheima.exception.BusinessException;
import com.itheima.service.UserServivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserServivce userServivce;

    @GetMapping("/{uuid}")
    public ResponseResult get(@PathVariable("uuid") Integer uuid){
        User user = this.userServivce.get(uuid);
        //当如何出现异常：抛出异常，并指定异常消息，和操作错误编码
        if (true)throw new BusinessException("根据用户的uuid查询失败！",ConstantMessage.GET_ERROR);
        return new ResponseResult(user!=null?ConstantMessage.GET_OK:ConstantMessage.GET_ERROR,user);
    }

    @GetMapping("/{page}/{size}")
    public ResponseResult  finAll(@PathVariable("page") Integer page,@PathVariable("size") Integer size){
        PageInfo<User> all = this.userServivce.getAll(page, size);
        return  new ResponseResult(all!=null?ConstantMessage.GETALL_OK:ConstantMessage.GETALL_ERROR,all);
    }
    @PostMapping("/login")
    public ResponseResult login(String userName,String password){
        User user = this.userServivce.login(userName, password);
        return new ResponseResult(user!=null?ConstantMessage.LOGIN_OK:ConstantMessage.LOGIN_ERROR,user);
    }


    @PostMapping
    public ResponseResult save(@RequestBody User user){
        boolean save = this.userServivce.save(user);
        return new ResponseResult(save?ConstantMessage.SAVE_OK:ConstantMessage.SAVE_ERROR);
    }
    @PutMapping
    public ResponseResult update(@RequestBody User user){
        boolean update = this.userServivce.update(user);
        return new ResponseResult(update? ConstantMessage.UPADTE_OK:ConstantMessage.UPADTE_ERROR);
    }
    @DeleteMapping("/{uuid}")
    public ResponseResult delete(@PathVariable Integer uuid){
        boolean delete = this.userServivce.delete(uuid);
        return new ResponseResult(delete ? ConstantMessage.DELETE_OK:ConstantMessage.DELETE_ERROR);
    }

}
