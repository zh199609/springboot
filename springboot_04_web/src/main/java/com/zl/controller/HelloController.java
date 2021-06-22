package com.zl.controller;

import com.zl.exception.UserNotExistsException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Map;

@Controller
public class HelloController {

    @RequestMapping("/success")
    public String success(Map<String, Object> map) {
        map.put("hello", "spring <br/>boot  zl");
        map.put("users", Arrays.asList("001", "002", "003"));
        return "success";
    }

    @RequestMapping("/hello")
    public String hello() {
        if (1 == 1) {
            throw new UserNotExistsException();
        }
        return "success";
    }


    @RequestMapping(value = "/signIn")
    @ResponseBody
    public String singIn(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.setAttribute("a", "a");
        return "singIn";
    }

    @RequestMapping(value = "/echo")
    @ResponseBody
    public String echo(HttpServletRequest request) {
        HttpSession session = request.getSession();
        Enumeration<String> names = session.getAttributeNames();
        while (names.hasMoreElements()) {
            String element = names.nextElement();
            System.out.println(session.getAttribute(element));
        }
        return "echo";
    }

    @RequestMapping(value = "/signOut")
    @ResponseBody
    public String signOut(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.invalidate();
        return "signOut";
    }
}
