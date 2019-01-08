package com.ibears.miaosha.service.impl;

import com.ibears.miaosha.dao.GoodsDao;
import com.ibears.miaosha.service.GoodsService;
import com.ibears.miaosha.vo.GoodsVo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author xiaoxiong
 * @date 2019/1/8 22:35
 */
@Service
public class GoodsServiceImpl implements GoodsService{
    
    @Autowired
    private GoodsDao goodsDao;
    
    @Override
    public List<GoodsVo> findGoodsList() {
        return goodsDao.findGoodsList();
    }
    
    @Override
    public GoodsVo findById(Long id) {
        return goodsDao.findById(id);
    }
}
