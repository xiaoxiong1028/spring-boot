package com.ibears.miaosha.redis;

/**
 * @author xiaoxiong
 * @date 2018/12/26 22:29
 */
public interface KeyPrefix {
    
    /**
     * @return
     */
    int expireSeconds();
    
    /**
     *
     * @return
     */
    String getPrefix();
}
