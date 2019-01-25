package com.zl.task;

import com.zl.value.Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @Author
 * @Description
 * @Date
 */
@Configuration
public class TestTask {

    @Autowired
    Entity entity;

    @Scheduled(fixedDelay = 5000)
    public void  task1(){
        System.out.println(entity);
        System.out.println("execute task");
    }
}
