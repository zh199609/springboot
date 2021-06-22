package com.zl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 * @ClassName: TestController
 * @Description:
 * @Author: albertzh
 * @Create: 2019-11-18 21:29
 */
@Controller
public class TestController {
    @RequestMapping(value = "/index")
    public String index() {
        return "fileTest";
    }

    @RequestMapping(value = "/fileUpload")
    @ResponseBody
    public String fileUpload(@RequestParam("multipartFile") MultipartFile file) {
        System.out.println(file.getSize());
        return "asd56g4a6sd4g";
    }


    @RequestMapping(value = "/data")
    @ResponseBody
    public String data(User user) {
        System.out.println(user);
        return "Success";
    }
}
