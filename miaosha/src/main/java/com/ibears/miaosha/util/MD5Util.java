package com.ibears.miaosha.util;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * @author xiaoxiong
 * @date 2018/12/27 23:23
 */
public class MD5Util {
    
    
    /**
     * md5 加密
     *
     * @param src
     * @return
     */
    public static String md5(String src) {
        return DigestUtils.md2Hex(src);
    }
    
   
    public static String inputPassToDBPass(String formPass, String slat) {
        String str = "" + slat.charAt(0) + slat.charAt(2) + formPass + slat.charAt(4) + slat.charAt(5);
        return md5(str);
    }
    
    
    public static void main(String[] args) {
        System.out.println(inputPassToDBPass("123456","#$&sejkfsg"));
        
    }
    
    
}
