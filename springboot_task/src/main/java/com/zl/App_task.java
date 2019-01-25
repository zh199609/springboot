package com.zl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @Author
 * @Description
 * @Date
 */
@EnableScheduling // 启动定时任务
@SpringBootApplication
public class App_task {
    public static void main(String[] args) {
        SpringApplication.run(App_task.class, args);
    }
}
