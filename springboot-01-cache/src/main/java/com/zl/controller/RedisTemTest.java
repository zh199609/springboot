package com.zl.controller;

import com.zl.config.redis.RedisProperties;
import com.zl.config.redis.SteelRedisTemplateImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RedisTemTest {

    @Autowired
    private SteelRedisTemplateImpl<String> redisTemplate;

    @Autowired
    private RedisProperties redisProperties;


    @RequestMapping("add1/{val}")
    public void add1(@PathVariable("val") String val) {
        redisTemplate.Add("key::1", val);
    }

    @RequestMapping("add2/{val}")
    public void add2(@PathVariable("val") String val) {
        redisTemplate.Add("key::2", val, redisProperties.getExpire());
    }

    @RequestMapping(value = "get/{key}")
    public String get(@PathVariable("key") String key) {
        return redisTemplate.Get(key);
    }
}
