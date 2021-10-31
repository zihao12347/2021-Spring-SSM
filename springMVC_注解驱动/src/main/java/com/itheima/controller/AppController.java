package com.itheima.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("/config")
public class AppController {
    @RequestMapping("/testConfig")
    public String testConfig(){
        return "/success.jsp";
    }
}
