package com.zl.config.redis;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;


@Configuration
public class RedisProperties {

    /**
     * 缓存过期时间
     */
    @Value("${spring.redis.expire}")
    private int expire;

    /**
     * 缓存穿透过期时间
     */
    @Value("${spring.redis.penetrate}")
    private int penetrate;


    public int getExpire() {
        return expire;
    }

    public void setExpire(int expire) {
        this.expire = expire;
    }

    public int getPenetrate() {
        return penetrate;
    }

    public void setPenetrate(int penetrate) {
        this.penetrate = penetrate;
    }
}
