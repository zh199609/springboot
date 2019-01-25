package com.zl;

import com.zl.value.Entity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Properties;

/**
 * @Author
 * @Description
 * @Date
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class App_test {


    @Autowired
    Entity entity;

    @Test
    public void test1() {
        Properties properties = System.getProperties();
        String username = properties.getProperty("username");
        System.out.println(username);
        System.out.println(entity);
    }

}


