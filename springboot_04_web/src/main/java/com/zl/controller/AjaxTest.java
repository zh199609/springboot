package com.zl.controller;

import com.zl.entities.Department;
import com.zl.entities.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class AjaxTest {

    @RequestMapping(value = "/ajaxTest")
    @ResponseBody
    public Department test(@RequestBody Department department) {
        System.out.println(department);
        return department;
    }

    @RequestMapping(value = "/ajax")
    @ResponseBody
    public String joinTest() {
        System.out.println("11111111111111111");
        return "AjaxTest";
    }


    @RequestMapping(value = "/fileTest")
    public String index() {
        return "fileTest";
    }

    @RequestMapping(value = "/data")
    @ResponseBody
    public String getData(MultipartFile file) {
        System.out.println(file.getName());
//        System.out.println(employee);
        return "Success";
    }
}
