package com.ibears.miaosha.controller;

import com.ibears.miaosha.redis.RedisService;
import com.ibears.miaosha.result.Result;
import com.ibears.miaosha.service.MiaoshaUserService;
import com.ibears.miaosha.vo.LoginVo;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author xiaoxiong
 * @date 2018/12/25 21:03
 */
@Controller
@RequestMapping(value = "/login")
public class AppLoginController {
    
    private static Logger logger = LoggerFactory.getLogger(AppLoginController.class);
    
    
    @Autowired
    private RedisService redisService;
    
    @Autowired
    private MiaoshaUserService miaoshaUserService;
    
    @RequestMapping(value = "/to_login")
    public String toLogin() {
        return "login";
    }
    
    
    @PostMapping(value = "/do_login")
    @ResponseBody
    public Result<Boolean> doLogin(@Valid LoginVo loginVo) {
        logger.info(loginVo.toString());
        miaoshaUserService.Login(loginVo);
        return Result.success(true);
    }
    
    
}
