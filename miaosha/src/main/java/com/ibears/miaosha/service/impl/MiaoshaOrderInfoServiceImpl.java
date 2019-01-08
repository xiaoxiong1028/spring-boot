package com.ibears.miaosha.service.impl;

import com.ibears.miaosha.dao.MiaoshaOrderInfoDao;
import com.ibears.miaosha.service.MiaoshaOrderInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author xiaoxiong
 * @date 2019/1/8 22:40
 */
@Service
public class MiaoshaOrderInfoServiceImpl implements MiaoshaOrderInfoService {
    
    @Autowired
    private MiaoshaOrderInfoDao miaoshaOrderInfoDao;
    
}
