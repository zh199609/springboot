package com.zl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class LoginController {

    @PostMapping("/user/login")
    public String login(@RequestParam("userName") String usernName,
                        @RequestParam("passWord") String passWord,
                        Map<String, Object> map, HttpSession session) {
        if (!StringUtils.isEmpty(usernName) && "1".equals(passWord)) {
            session.setAttribute("login",usernName);
            return "redirect:/main";
        }
        map.put("msg","用户名或者密码错误！");
        return "/index";
    }
}
