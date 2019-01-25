package com.zl.controller;

import com.zl.entities.Department;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AjaxTest {

    @RequestMapping(value = "/ajaxTest")
    @ResponseBody
    public Department test(@RequestBody Department department){
        System.out.println(department);
        return department;
    }

    @RequestMapping(value = "/ajax")
    public String joinTest(){
        return "AjaxTest";
    }

}
