package com.ibears.miaosha.redis;

/**
 * @author xiaoxiong
 * @date 2018/12/26 23:04
 */
public class UserKey extends BasePrefix {
    
    
    public UserKey(String prefix) {
        super(prefix);
    }
    
    public static UserKey getById = new UserKey("id");
    
    public static UserKey getByName = new UserKey("name");
    
    
}
