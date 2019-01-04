package com.ibears.miaosha.redis;

/**
 * @author xiaoxiong
 * @date 2018/12/26 23:04
 */
public class MiaoshaUserKey extends BasePrefix {
    
    
    private static  final int TOKEN_EXPIRE = 3600;
    
    public MiaoshaUserKey(String prefix) {
        super(prefix);
    }
   
    public MiaoshaUserKey(int expireSeconds, String prefix) {
        super(expireSeconds, prefix);
    }
    
    public static MiaoshaUserKey token = new MiaoshaUserKey(TOKEN_EXPIRE,"token");
    
    
    
}
