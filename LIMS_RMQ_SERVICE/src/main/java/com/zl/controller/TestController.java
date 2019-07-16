package com.zl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class TestController {


    @Autowired
    private Sender sender;

    @RequestMapping(value = "/test1")
    public String test1() {
        Map<String, Object> hashMap = new HashMap();
        hashMap.put("params", new String[]{"测试用户", "Java开发教室", "22点02分-23点02分"});
        hashMap.put("phoneNumber", "15824349156");
        hashMap.put("status", true);
        sender.sendRoom(hashMap);
        return "Success";
    }

    @RequestMapping(value = "/test2")
    public String test2() {
        Map<String, Object> hashMap = new HashMap();
        hashMap.put("params", new String[]{"测试用户", "Java开发教室"});
        hashMap.put("phoneNumber", "15824349156");
        hashMap.put("status", false);
        sender.sendRoom(hashMap);
        return "Success";
    }


    @RequestMapping(value = "/test3")
    public String test3() {
        Map<String, Object> hashMap = new HashMap();
        hashMap.put("params", new String[]{"测试用户", "华为路由器", "13点51分-23点02分"});
        hashMap.put("phoneNumber", "15824349156");
        hashMap.put("status", true);
        sender.sendEquipment(hashMap);
        return "Success";
    }


    @RequestMapping(value = "/test4")
    public String test4() {
        Map<String, Object> hashMap = new HashMap();
        hashMap.put("params", new String[]{"测试用户", "华为路由器"});
        hashMap.put("phoneNumber", "15824349156");
        hashMap.put("status", false);
        sender.sendEquipment(hashMap);
        return "Success";
    }
}
