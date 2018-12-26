package com.ibears.miaosha.redis;

/**
 * @author xiaoxiong
 * @date 2018/12/26 22:32
 */
public abstract class BasePrefix implements KeyPrefix {
    
    private int expireSeconds;
    
    private String prefix;
    
    
    public BasePrefix(String prefix) {
        this(0, prefix);
    }
    
    
    public BasePrefix(int expireSeconds, String prefix) {
        this.expireSeconds = expireSeconds;
        this.prefix = prefix;
    }
    
    @Override
    public int expireSeconds() {//0表示永久有效
        return expireSeconds;
    }
    
    @Override
    public String getExpireSeconds() {
        String className = getClass().getSimpleName();
        return className + ":" + prefix;
    }
    
    
    public void setExpireSeconds(int expireSeconds) {
        this.expireSeconds = expireSeconds;
    }
    
    public String getPrefix() {
        return prefix;
    }
    
    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }
}
