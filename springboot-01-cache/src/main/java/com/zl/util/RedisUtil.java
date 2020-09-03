/*
 * CMB Confidential
 *
 * Copyright (C) 2020 China Merchants Bank Co., Ltd. All rights reserved.
 *
 * No part of this file may be reproduced or transmitted in any form or by any
 * means, electronic, mechanical, photocopying, recording, or otherwise, without
 * prior written permission of China Merchants Bank Co., Ltd.
 */
package com.zl.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @Author albertzh
 * @Description
 * @Date 2020/9/211:01
 **/
@Component
public class RedisUtil {
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    /**
     * 指定缓存失效时间
     *
     * @param key
     * @param time
     * @return
     */
    public boolean expire(String key, long time) {
        try {
            if (time > 0) {
                return redisTemplate.expire(key, time, TimeUnit.SECONDS);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public long getExpire(String key) {
        return redisTemplate.getExpire(key);
    }

    public boolean hasKey(String key) {
        try {
            redisTemplate.hasKey(key);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean del(String... keys) {
        try {
            if (null != keys && keys.length > 0) {
                if (keys.length == 1) {
                    redisTemplate.delete(keys[0]);
                } else {
                    redisTemplate.delete(Arrays.asList(keys));
                }
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 普通缓存获取
     *
     * @param key
     * @return
     */
    public Object get(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    /**
     * 普通缓存保存
     *
     * @param key
     * @param o
     * @return
     */
    public boolean set(String key, Object o) {
        try {
            redisTemplate.opsForValue().set(key, o);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 普通缓存保存，设置时间
     *
     * @param key
     * @param o
     * @param expire
     * @return
     */
    public boolean set(String key, Object o, long expire) {
        try {
            if (expire > 0) {
                redisTemplate.opsForValue().set(key, o, expire, TimeUnit.SECONDS);
            } else {
                redisTemplate.opsForValue().set(key, o);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 递增
     *
     * @param key
     * @param delta
     * @return
     */
    public boolean incr(String key, int delta) {
        try {
            if (delta > 0) {
                redisTemplate.opsForValue().increment(key, delta);
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean decr(String key, int delta) {
        try {
            if (delta < 0) {
                redisTemplate.opsForValue().decrement(key, delta);
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * HashGet
     *
     * @param key  k
     * @param item field
     * @return
     */
    public Object hget(String key, String item) {
        return redisTemplate.opsForHash().get(key, item);
    }

    /**
     * 获取hashKey对应的所有键值
     *
     * @param key
     * @return
     */
    public Map<Object, Object> hmget(String key) {
        return redisTemplate.opsForHash().entries(key);
    }

    public void hmset(String key, Map<String, Object> map) {
        redisTemplate.opsForHash().putAll(key, map);
    }

    public boolean hmset(String key, Map<String, Object> map, long time) {
        try {
            redisTemplate.opsForHash().putAll(key, map);
            if (time > 0) {
                expire(key, time);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 向一张hash表中放入数据，如果不存在将创建
     *
     * @param key
     * @param item
     * @param value
     * @return
     */
    public boolean hset(String key, String item, Object value) {
        try {
            redisTemplate.opsForHash().put(key, item, value);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 删除hash表中的值
     *
     * @param key
     * @param item
     */
    public void hdel(String key, Object... item) {
        redisTemplate.opsForHash().delete(key, item);
    }

    /**
     * 判断hash表中是否存在该项的值
     *
     * @param key
     * @param item
     * @return
     */
    public boolean hHasKey(String key, String item) {
        return redisTemplate.opsForHash().hasKey(key, item);
    }

    /**
     * hash递增，如果不存在，就会创建一个，并把新增后的值返回
     *
     * @param key
     * @param item
     * @param by
     * @return
     */
    public double hincr(String key, String item, double by) {
        return redisTemplate.opsForHash().increment(key, item, by);
    }

    /**
     * 根据key获取set中的所有值
     *
     * @param set
     * @return
     */
    public Set<Object> sGet(String set) {
        try {
            return redisTemplate.opsForSet().members(set);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 根据val从一个set中查询是否存在
     *
     * @param key
     * @param val
     * @return
     */
    public boolean sHasKey(String key, Object val) {
        try {
            return redisTemplate.opsForSet().isMember(key, val);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 将数据放入set缓存
     *
     * @param set
     * @param val
     * @return
     */
    public long sSet(String set, Object... val) {
        try {
            return redisTemplate.opsForSet().add(set, val);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * 获取set缓存的长度
     *
     * @param set
     * @return
     */
    public long sGetSetSize(String set) {
        try {
            return redisTemplate.opsForSet().size(set);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * 移除值为value
     *
     * @param key
     * @param val
     * @return
     */
    public long setRemove(String key, Object... val) {
        try {
            return redisTemplate.opsForSet().remove(key, val);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * 获取List缓存
     *
     * @param key
     * @param start
     * @param end
     * @return
     */
    public List<Object> lGet(String key, long start, long end) {
        try {
            return redisTemplate.opsForList().range(key, start, end);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取list索引的值
     *
     * @param key
     * @param index
     * @return
     */
    public Object lGetIndex(String key, long index) {
        try {
            return redisTemplate.opsForList().index(key, index);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 再list缓存中右插入
     *
     * @param key
     * @param value
     * @return
     */
    public boolean lSet(String key, Object value) {
        try {
            redisTemplate.opsForList().rightPush(key, value);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     *将数据放入list缓存
     * @param key
     * @param list
     * @return
     */
    public boolean lSet(String key, List<Object> list) {
        try {
            redisTemplate.opsForList().rightPushAll(key, list);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
