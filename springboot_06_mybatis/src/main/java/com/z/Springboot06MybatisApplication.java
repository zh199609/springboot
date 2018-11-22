package com.z;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(value = "com.z.mapper")
public class Springboot06MybatisApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springboot06MybatisApplication.class, args);
    }
}
