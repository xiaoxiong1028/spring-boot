package com.ibears.miaosha.service.impl;

import com.ibears.miaosha.dao.MiaoshaUserDao;
import com.ibears.miaosha.domain.MiaoshaUser;
import com.ibears.miaosha.result.CodeMassage;
import com.ibears.miaosha.service.MiaoshaUserService;
import com.ibears.miaosha.util.MD5Util;
import com.ibears.miaosha.vo.LoginVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author xiaoxiong
 * @date 2018/12/29 13:38
 */
@Service
public class MiaoshaUserServiceImpl implements MiaoshaUserService {
    
    @Autowired
    private MiaoshaUserDao miaoshaUserDao;
    
    @Override
    public CodeMassage Login(LoginVo loginVo) {
        if (null == loginVo) {
            return CodeMassage.SERVER_ERROR;
        }
        String mobile   = loginVo.getMobile();
        String password = loginVo.getPassword();
        //用户是否存在
        MiaoshaUser userById = miaoshaUserDao.findUserById(Long.valueOf(mobile));
        if (null == userById) {
            return CodeMassage.MOBILE_NOT_EXIST;
        }
        String calcPass = MD5Util.fromPassToDBPass(password, userById.getSalt());
        if (!calcPass.equals(userById.getPassword())) {
            return CodeMassage.PASSWORD_ERROR;
        }
        return CodeMassage.SUCCESS;
    }
}
