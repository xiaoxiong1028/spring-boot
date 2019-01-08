package com.ibears.miaosha.dao;

import com.ibears.miaosha.vo.GoodsVo;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @author xiaoxiong
 * @date 2019/1/8 22:34
 */
@Repository
@Mapper
public interface GoodsDao {

    @Select("SELECT goods.*,miaosha_goods.miaosha_price,miaosha_goods.stock_Count,miaosha_goods.start_date,miaosha_goods.end_date from miaosha_goods LEFT JOIN goods on  miaosha_goods.goods_id = goods.id ")
    public List<GoodsVo> findGoodsList();
    
    
    @Select("SELECT goods.*,miaosha_goods.miaosha_price,miaosha_goods.stock_Count,miaosha_goods.start_date,miaosha_goods.end_date from miaosha_goods LEFT JOIN goods on  miaosha_goods.goods_id = goods.id where miaosha_goods.goods_id = #{id}")
    GoodsVo findById(Long id);
    
}
