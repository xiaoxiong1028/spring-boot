package com.ibears.miaosha.service.impl;

import com.ibears.miaosha.dao.OrderInfoDao;
import com.ibears.miaosha.service.OrderInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author xiaoxiong
 * @date 2019/1/8 22:36
 */
@Service
public class OrderInfoServiceImpl implements OrderInfoService {
    
    @Autowired
    private OrderInfoDao orderInfoDao;
    
}
