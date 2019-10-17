package com.zl;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.zl.mapper")
public class App {

    //启动
    public static void main(String[] args) {
//        System.setProperty("mail.mime.splitlongparameters", "false");
        SpringApplication.run(App.class, args);//profiles.active
    }
}
