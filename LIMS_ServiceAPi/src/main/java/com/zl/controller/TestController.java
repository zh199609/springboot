package com.zl.controller;

import com.zl.config.PhoneConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {
    @Autowired
    private PhoneConfig phoneConfig;


    @RequestMapping("/")
    public String get() {
        System.out.println(phoneConfig);
        return "redirect:/swagger-ui.html#/";
    }
}
