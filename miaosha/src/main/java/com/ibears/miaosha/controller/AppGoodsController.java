package com.ibears.miaosha.controller;

import com.ibears.miaosha.domain.MiaoshaUser;
import com.ibears.miaosha.service.GoodsService;
import com.ibears.miaosha.service.MiaoshaUserService;
import com.ibears.miaosha.vo.GoodsVo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
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
    
    @Autowired
    private GoodsService goodsService;
    
    @RequestMapping(value = "/to_list")
    public String toList(Model model, MiaoshaUser miaoshaUser) {
        List<GoodsVo> goodsList = goodsService.findGoodsList();
        model.addAttribute("user", miaoshaUser);
        model.addAttribute("goodsList", goodsList);
        return "goods_list";
    }
    
    @RequestMapping(value = "/to_detail/{goodsId}")
    public String to_detail(Model model, MiaoshaUser miaoshaUser,@PathVariable(value = "goodsId") Long goodsId) {
       GoodsVo  goods = goodsService.findById(goodsId);
        model.addAttribute("user", miaoshaUser);
        model.addAttribute("goods", goods);
        long startAt = goods.getStartDate().getTime();
        long endAt = goods.getEndDate().getTime();
        long now = System.currentTimeMillis();
    
        int miaoshaStatus = 0;
        int remainSeconds = 0;
        //秒杀还没开始，倒计时
        if(now < startAt ) {
            miaoshaStatus = 0;
            remainSeconds = (int)((startAt - now )/1000);
            //秒杀已经结束
        }else  if(now > endAt){
            miaoshaStatus = 2;
            remainSeconds = -1;
            //秒杀进行中
        }else {
            miaoshaStatus = 1;
            remainSeconds = 0;
        }
        model.addAttribute("miaoshaStatus", miaoshaStatus);
        model.addAttribute("remainSeconds", remainSeconds);
        return "goods_detail";
        
    }
    
}
