package com.ibears.miaosha.util;

import com.alibaba.druid.util.StringUtils;
import java.util.regex.Pattern;

/**
 * @author xiaoxiong
 * @date 2018/12/29 13:25
 */
public class ValidtaorUtil {
    
    private static final Pattern mobile_pattern = Pattern.compile("1\\d{10}");
    
    /**
     * 校验是否手机号
     *
     * @param mobile
     * @return
     */
    public static Boolean isMobile(String mobile) {
        if (StringUtils.isEmpty(mobile)) {
            return false;
        }
        return mobile_pattern.matcher(mobile).matches();
    }
    
}
