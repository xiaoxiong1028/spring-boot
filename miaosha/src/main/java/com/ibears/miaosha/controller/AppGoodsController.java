package com.ibears.miaosha.controller;

import com.alibaba.druid.util.StringUtils;
import com.ibears.miaosha.domain.MiaoshaUser;
import com.ibears.miaosha.redis.RedisService;
import com.ibears.miaosha.service.MiaoshaUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author xiaoxiong
 * @date 2019/1/5 00:08
 */
@Controller
@RequestMapping(value = "/goods")
public class AppGoodsController {
    
    @Autowired
    private MiaoshaUserService miaoshaUserService;
    
    @Autowired
    private RedisService redisService;
    
    @RequestMapping(value = "/to_list")
    public String toList(Model model,
                         @CookieValue(value = MiaoshaUserService.COOKIE_NAME_TOKEN,required = false) String  cookieToken,
                         @RequestParam(value = MiaoshaUserService.COOKIE_NAME_TOKEN,required = false) String paramToken) {
        if (StringUtils.isEmpty(cookieToken) && StringUtils.isEmpty(paramToken)){
            return "login";
        }
        String token = StringUtils.isEmpty(cookieToken)?paramToken:cookieToken;
        MiaoshaUser miaoshaUser =  miaoshaUserService.getByToken(token);
        model.addAttribute("user",miaoshaUser);
        return "goods_list";
    }
    
}
