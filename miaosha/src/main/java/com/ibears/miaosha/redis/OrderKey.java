package com.ibears.miaosha.redis;

/**
 * @author xiaoxiong
 * @date 2018/12/26 23:06
 */
public class OrderKey extends BasePrefix{
    
    public OrderKey(int expireSeconds, String prefix) {
        super(expireSeconds, prefix);
    }
    
    
    
    
    
}
