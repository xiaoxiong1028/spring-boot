package com.ibears.miaosha.controller;

import com.ibears.miaosha.redis.RedisService;
import com.ibears.miaosha.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xiaoxiong
 * @date 2018/12/25 21:03
 */
@RestController
@RequestMapping(value = "/app")
public class AppController {
    
    @Autowired
    private RedisService redisService;
    
    
    @RequestMapping(value = "/redis/get")
    public Result<String> redisGet() {
        String key1 = redisService.getString("key1", String.class);
        return Result.success(key1);
    }
    
    @RequestMapping(value = "/redis/set")
    public Result<Boolean> redisSet() {
        boolean key1 = redisService.set("key1", "ceshi");
        return Result.success(key1);
    }
    
    
}
