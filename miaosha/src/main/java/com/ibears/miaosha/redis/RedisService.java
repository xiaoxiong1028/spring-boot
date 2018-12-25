package com.ibears.miaosha.redis;

import com.alibaba.druid.util.StringUtils;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * @author xiaoxiong
 * @date 2018/12/25 21:02
 */
@Component
public class RedisService {
    
    @Autowired
    private JedisPool jedisPool;
    
    public <T> T getString(String key, Class<T> Clazz) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            String s = jedis.get(key);
            T      t = stringToBean(s, Clazz);
            return t;
        } finally {
            returnToPool(jedis);
        }
     
    }
    
    /**
     * 设置
     *
     * @param key
     * @param value
     * @param <T>
     * @return
     */
    public <T> boolean set(String key, T value) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            String str = beanToString(value);
            jedis.set(key, str);
            return true;
        } finally {
            returnToPool(jedis);
        }
       
    }
    
    
    private <T> T stringToBean(String string, Class<T> clazz) {
        if (StringUtils.isEmpty(string)) {
            return null;
        }
        if (clazz == int.class || clazz == Integer.class) {
            return (T) Integer.valueOf(string);
        } else if (clazz == long.class || clazz == Long.class) {
            return (T) Long.valueOf(string);
        } else if (clazz == String.class) {
            return (T) string;
        } else {
            return JSON.parseObject(string, clazz);
        }
    }
    
    
    private <T> String beanToString(T value) {
        if (null == value) {
            return null;
        }
        Class<?> clazz = value.getClass();
        if (clazz == int.class || clazz == Integer.class) {
            return "" + value;
        } else if (clazz == long.class || clazz == Long.class) {
            return "" + value;
        } else if (clazz == String.class) {
            return (String) value;
        } else {
            return JSON.toJSONString(value);
        }
    }
    
    /**
     * 释放jedis
     *
     * @param jedis
     */
    private void returnToPool(Jedis jedis) {
        if (null != jedis) {
            jedis.close();
        }
    }
    
    
}
