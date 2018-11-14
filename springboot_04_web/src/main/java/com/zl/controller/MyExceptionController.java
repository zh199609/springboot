package com.zl.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class MyExceptionController {

    //浏览器和客户端都返回json
    /*@ExceptionHandler({Exception.class})
    @ResponseBody
    public Map<String, Object> handlerException(Exception e){
        Map<String, Object> map = new HashMap<>();
        map.put("code","user not exists");
        map.put("exception",e.getMessage());
        return  map;
    }*/

    @ExceptionHandler({Exception.class})
    @ResponseBody
    public Map<String, Object> handlerException(Exception e){
        Map<String, Object> map = new HashMap<>();
        map.put("code","user not exists");
        map.put("exception",e.getMessage());
        return  map;
    }

}
