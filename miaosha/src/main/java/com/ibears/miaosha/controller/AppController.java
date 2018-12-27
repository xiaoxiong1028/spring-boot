package com.ibears.miaosha.controller;

import com.ibears.miaosha.domain.User;
import com.ibears.miaosha.redis.RedisService;
import com.ibears.miaosha.redis.UserKey;
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
        String key1 = redisService.getString(UserKey.getById,"key1", String.class);
        return Result.success(key1);
    }
    
    @RequestMapping(value = "/redis/set")
    public Result<Boolean> redisSet() {
        User user= new User(1L,"用户");
        boolean key1 = redisService.set(UserKey.getById,"key1", user);
        return Result.success(key1);
    }
    
    
}
