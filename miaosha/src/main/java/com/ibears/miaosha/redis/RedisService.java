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
    
    /**
     * 获取单个对象
     *
     * @param prefix
     * @param key
     * @param Clazz
     * @param <T>
     * @return
     */
    public <T> T getString(KeyPrefix prefix, String key, Class<T> Clazz) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            String realKey = prefix.getPrefix() + ":" + key;
            String s       = jedis.get(realKey);
            T      t       = stringToBean(s, Clazz);
            return t;
        } finally {
            returnToPool(jedis);
        }
        
    }
    
    /**
     * 设置对象
     *
     * @param key
     * @param value
     * @param <T>
     * @return
     */
    public <T> boolean set(KeyPrefix prefix, String key, T value) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            String str     = beanToString(value);
            String realKey = prefix.getPrefix() + ":" + key;
            if (0 <= prefix.expireSeconds()) {
                jedis.set(realKey, str);
            } else {
                jedis.setex(realKey, prefix.expireSeconds(), str);
            }
            return true;
        } finally {
            returnToPool(jedis);
        }
        
    }
    
    /**
     * 判断是否存在
     *
     * @param prefix
     * @param key
     * @param <T>
     * @return
     */
    public <T> boolean exists(KeyPrefix prefix, String key) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            String realKey = prefix.getPrefix() + ":" + key;
            jedis.exists(realKey);
            return true;
        } finally {
            returnToPool(jedis);
        }
    }
    
    /**
     * 增加值
     * @param prefix
     * @param key
     * @param <T>
     * @return
     */
    public <T> Long incr(KeyPrefix prefix, String key) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            String realKey = prefix.getPrefix() + ":" + key;
            return jedis.incr(realKey);
        } finally {
            returnToPool(jedis);
        }
        
    }
    
    /**
     * 减少值
     * @param prefix
     * @param key
     * @param <T>
     * @return
     */
    public <T> Long decr(KeyPrefix prefix, String key) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            String realKey = prefix.getPrefix() + ":" + key;
            return jedis.decr(realKey);
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
