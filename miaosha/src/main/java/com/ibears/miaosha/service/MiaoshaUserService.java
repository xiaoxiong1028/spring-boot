package com.ibears.miaosha.service;

import com.ibears.miaosha.domain.MiaoshaUser;
import com.ibears.miaosha.result.CodeMassage;
import com.ibears.miaosha.vo.LoginVo;
import javax.servlet.http.HttpServletResponse;

/**
 * @author xiaoxiong
 * @date 2018/12/29 13:38
 */
public interface MiaoshaUserService {
    
    
    public static final String COOKIE_NAME_TOKEN = "token";
    
    /**
     * 登陆方法
     * @param loginVo
     * @return
     */
    CodeMassage Login(HttpServletResponse response ,LoginVo loginVo);
    
    /**
     * 获取用户信息
     * @param token
     * @return
     */
    MiaoshaUser getByToken(HttpServletResponse response,String token);
    
}
