package com.zl.config.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @author tengxh
 * @date 2018-03-27
 * Redis操作
 */
@Component
public class SteelRedisTemplateImpl<T> {
    @Autowired
    private RedisProperties redisProperties;

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 存储对象
     *
     * @param key
     * @param obj 存储对象
     */

    public void Add(String key, T obj) {
        try {
            if (obj != null) {
                redisTemplate.opsForValue().set(key, obj);
            } else {
                redisTemplate.opsForValue().set(key, (T) new Object());
                redisTemplate.expire(key, redisProperties.getPenetrate(), TimeUnit.MINUTES);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 存储对象
     *
     * @param key
     * @param obj        存储对象
     * @param expireTime 过期时间
     */

    public void Add(String key, T obj, int expireTime) {
        try {
            if (obj != null) {
                redisTemplate.opsForValue().set(key, obj);
                redisTemplate.expire(key, expireTime, TimeUnit.MINUTES);
            } else {
                redisTemplate.opsForValue().set(key, (T) new Object());
                redisTemplate.expire(key, redisProperties.getPenetrate(), TimeUnit.MINUTES);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取对象
     */
    public T Get(String key) {
        T t = null;
        try {
            t = (T) redisTemplate.opsForValue().get(key);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return t;
        }
    }

    /**
     * 移除对象
     */
    public void Remove(String key) {
        try {
            redisTemplate.delete(key);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
