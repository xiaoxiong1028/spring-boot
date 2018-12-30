package com.ibears.miaosha.dao;

import com.ibears.miaosha.domain.MiaoshaUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @author xiaoxiong
 * @date 2018/12/29 13:38
 */
@Mapper
@Repository
public interface MiaoshaUserDao {
    
    @Select("select * from miaosha_user where id = #{id}")
    public MiaoshaUser findUserById(@Param("id") Long id);
    
}
