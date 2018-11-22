package com.zl.controller;

import com.zl.starter.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @Autowired
    private HelloService helloService;
    @RequestMapping("hello")
    public String getHello(){
        return helloService.sayHello("zl");
    }

}
