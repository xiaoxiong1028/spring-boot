package com.ibears.miaosha.service;

import com.ibears.miaosha.vo.GoodsVo;
import java.util.List;

/**
 * @author xiaoxiong
 * @date 2019/1/8 22:34
 */
public interface GoodsService {
    
    List<GoodsVo> findGoodsList();
    
    
    GoodsVo findById(Long id);
    
}
