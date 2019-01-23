package com.zl.controller;

import com.zl.entities.Department;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AjaxTest {

    @RequestMapping(value = "/ajaxTest")
    @ResponseBody
    public String test(Department department){
        System.out.println(department);
        return "成功提交数据！";
    }

    @RequestMapping(value = "/ajax")
    public String joinTest(){
        return "AjaxTest";
    }

}
