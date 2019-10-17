package com.zl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName: IndexController
 * @Description: Index
 * @Author: albertzh
 * @Create: 2019-10-16 15:27
 */
@Controller
public class IndexController {

    @RequestMapping(value = "/ajax")
    public String Ajax() {
        return "ajax";
    }
}
