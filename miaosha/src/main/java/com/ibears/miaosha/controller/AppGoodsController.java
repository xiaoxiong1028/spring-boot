package com.ibears.miaosha.controller;

import com.ibears.miaosha.domain.MiaoshaUser;
import com.ibears.miaosha.service.MiaoshaUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author xiaoxiong
 * @date 2019/1/5 00:08
 */
@Controller
@RequestMapping(value = "/goods")
public class AppGoodsController {
    
    @Autowired
    private MiaoshaUserService miaoshaUserService;
    
    
    @RequestMapping(value = "/to_list")
    public String toList(Model model, MiaoshaUser miaoshaUser) {
        model.addAttribute("user", miaoshaUser);
        return "goods_list";
    }
    
}
