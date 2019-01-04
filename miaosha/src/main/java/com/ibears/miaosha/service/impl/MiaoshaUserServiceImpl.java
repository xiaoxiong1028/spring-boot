package com.ibears.miaosha.service.impl;

import com.alibaba.druid.util.StringUtils;
import com.ibears.miaosha.dao.MiaoshaUserDao;
import com.ibears.miaosha.domain.MiaoshaUser;
import com.ibears.miaosha.exception.GlobalException;
import com.ibears.miaosha.redis.MiaoshaUserKey;
import com.ibears.miaosha.redis.RedisService;
import com.ibears.miaosha.result.CodeMassage;
import com.ibears.miaosha.service.MiaoshaUserService;
import com.ibears.miaosha.util.MD5Util;
import com.ibears.miaosha.util.UUIDUtil;
import com.ibears.miaosha.vo.LoginVo;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
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
    
    @Autowired
    private RedisService redisService;
    
    @Override
    public CodeMassage Login(HttpServletResponse response, LoginVo loginVo) {
        if (null == loginVo) {
            throw new GlobalException(CodeMassage.SERVER_ERROR);
        }
        String mobile   = loginVo.getMobile();
        String password = loginVo.getPassword();
        //用户是否存在
        MiaoshaUser userById = miaoshaUserDao.findUserById(Long.valueOf(mobile));
        if (null == userById) {
            throw new GlobalException(CodeMassage.MOBILE_NOT_EXIST);
        }
        String calcPass = MD5Util.inputPassToDBPass(password, userById.getSalt());
        if (!calcPass.equals(userById.getPassword())) {
            throw new GlobalException(CodeMassage.PASSWORD_ERROR);
        }
        //生成cookie
        String token = UUIDUtil.uuid();
        userById.setPassword(null);
        userById.setSalt(null);
        redisService.set(MiaoshaUserKey.token, token, userById);
        Cookie cookie = new Cookie(COOKIE_NAME_TOKEN, token);
        cookie.setMaxAge(MiaoshaUserKey.token.expireSeconds());
        cookie.setPath("/");
        response.addCookie(cookie);
        return CodeMassage.SUCCESS;
    }
    
    @Override
    public MiaoshaUser getByToken(String token) {
        if (StringUtils.isEmpty(token)){
            return null;
        }
        MiaoshaUser user = redisService.getString(MiaoshaUserKey.token, token, MiaoshaUser.class);
        return user;
    }
}
