package com.ibears.miaosha.service;

import com.ibears.miaosha.result.CodeMassage;
import com.ibears.miaosha.vo.LoginVo;

/**
 * @author xiaoxiong
 * @date 2018/12/29 13:38
 */
public interface MiaoshaUserService {
    
    /**
     * 登陆方法
     * @param loginVo
     * @return
     */
    CodeMassage Login(LoginVo loginVo);
    
}
