package com.zl.controller;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * @Author
 * @Description
 * @Date
 */
@Controller
public class UploadController {

    @RequestMapping(value = "zl/upload")
    public String upload(MultipartFile multipartFile) throws IOException {
        FileUtils.writeByteArrayToFile(new File("E:/upload.txt"), multipartFile.getBytes());
        return "SUCCESS";
    }

}
