/*
 * CMB Confidential
 *
 * Copyright (C) 2020 China Merchants Bank Co., Ltd. All rights reserved.
 *
 * No part of this file may be reproduced or transmitted in any form or by any
 * means, electronic, mechanical, photocopying, recording, or otherwise, without
 * prior written permission of China Merchants Bank Co., Ltd.
 */
package com.zl;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Response;
import redis.clients.jedis.Transaction;

import java.util.HashMap;
import java.util.Set;

/**
 * @Author albertzh
 * @Description
 * @Date 2020/8/2417:46
 **/
public class Main {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("192.168.154.128", 6379);
        System.out.println("连接成功");
        //查看服务是否运行
        System.out.println("服务正在运行: " + jedis.ping());
        String set = jedis.set("username111", "张磊");
        System.out.println(set);
        Set<String> keys = jedis.keys("*");
        System.out.println(keys);

        System.out.println("查看k的类型" + jedis.type("username111"));

        System.out.println("随机返回一个key：" + jedis.randomKey());
        System.out.println("key的数目：" + jedis.dbSize());
    }

    @Test
    public void testString() {
        Jedis jedis = new Jedis("192.168.154.128", 6379);
/*        jedis.set("k1","v1");
        jedis.set("k2","v2");
        jedis.set("k3","v3");
        System.out.println(jedis.mset("k01","v001","k02","v002"));*/
        jedis.flushDB();
        System.out.println(jedis.setnx("k1", "v1wer1"));
        System.out.println(jedis.setnx("k1", "v12"));
        System.out.println(jedis.setex("k3", 700, "v3"));
//        System.out.println(jedis.getSet("k3", "new_v3"));
        System.out.println(jedis.get("k3"));
        System.out.println(jedis.getrange("k1", 1, 2));
        System.out.println(jedis.ttl("k1"));
        System.out.println(jedis.ttl("k3"));
        System.out.println(jedis.setrange("k1", 1, "00000000"));
    }

    @Test
    public void testList() {
        Jedis jedis = new Jedis("192.168.154.128", 6379);
        jedis.flushDB();
        System.out.println(jedis.lpush("l1", "v11111", "v222222222", "vvvvvvvv3"));
        jedis.lpush("l1", "v0000000000");
        jedis.rpush("l1", "v0000000000");
        jedis.lpush("l1", "v0000000000");
        jedis.rpush("l1", "v0000000000");
        System.out.println(jedis.lrange("l1", 0, -1));
        System.out.println(jedis.lrem("l1", 1, "v0000000000"));
        System.out.println(jedis.lrange("l1", 0, -1));
//        System.out.println(jedis.ltrim("l1",0,1));
        System.out.println(jedis.llen("l1"));
        System.out.println(jedis.lrange("l1", 0, -1));

        System.out.println(jedis.lpop("l1"));
        System.out.println(jedis.lset("l1", 4, "5555555"));
        System.out.println(jedis.lindex("l1", 4));
        System.out.println(jedis.llen("l1"));
        jedis.lpush("l2", "1", "2", "65", "60", "9");
        System.out.println(jedis.sort("l2"));
    }


    @Test
    public void testSet() {
        Jedis jedis = new Jedis("192.168.154.128", 6379);
        System.out.println(jedis.flushDB());
        System.out.println(jedis.sadd("s1", "v1", "v2", "v3", "v3", "v4", "v1"));
        System.out.println(jedis.smembers("s1"));
        System.out.println("删除一个预算v1:" + jedis.srem("s1", "v1"));
        System.out.println(jedis.smembers("s1"));
        System.out.println("集合中包含元素的个数：" + jedis.scard("s1"));
        System.out.println("是否存在v2:" + jedis.sismember("s1", "v2"));

        System.out.println(jedis.sadd("s2", "v1", "v2", "v3", "v4", "v5", "v6", "v7", "v8", "v9"));
        System.out.println("集合元素移动：" + jedis.smove("s2", "s1", "v7"));
        System.out.println(jedis.smembers("s1"));
        System.out.println(jedis.smembers("s2"));
        System.out.println("=============集合运算=============");
        System.out.println("交集：" + jedis.sinter("s1", "s2"));
        System.out.println("并集：" + jedis.sunion("s1", "s2"));
        System.out.println("差集：" + jedis.sdiff("s1", "s2"));
    }


    @Test
    public void testHash() {
        Jedis jedis = new Jedis("192.168.154.128", 6379);
        System.out.println(jedis.flushDB());
        HashMap<String, String> map = new HashMap<>();
        map.put("m1", "v1");
        map.put("m2", "v2");
        map.put("m3", "v3");
        map.put("m4", "v4");
        map.put("m5", "v5");
        map.put("m6", "v6");
        map.put("m7", "v7");
        map.put("m8", "v8");
        map.put("m9", "v9");
        System.out.println(jedis.hset("h1", map));
        System.out.println(jedis.hgetAll("h1"));
        System.out.println(jedis.hincrBy("h1", "m10", 6));
        System.out.println(jedis.hincrBy("h1", "m10", 6));
        System.out.println(jedis.hgetAll("h1"));
        System.out.println("删除kv:" + jedis.hdel("h1", "m1"));
        System.out.println(jedis.hgetAll("h1"));
        System.out.println(jedis.hexists("h2", "m2"));
        System.out.println(jedis.hmget("h1", "m1", "m2", "m3", "m4"));
    }

    @Test
    public void testSortSet() {
        Jedis jedis = new Jedis("192.168.154.128", 6379);
        System.out.println(jedis.flushDB());
    }

    @Test
    public void testMulti() {
        Jedis jedis = new Jedis("192.168.154.128", 6379);
        jedis.flushDB();
        //开启事务

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("hello", "world");
        jsonObject.put("name", "java");
        Transaction multi = jedis.multi();
        String s = jsonObject.toJSONString();
        try {
            Response<String> k1 = multi.set("k1", s);
           int i = 100 / 0;
            multi.exec();
        } catch (Exception e) {
            e.printStackTrace();
            //回滚
            multi.discard();
        } finally {
            System.out.println(jedis.get("k1"));
            jedis.close();
        }
    }


}
