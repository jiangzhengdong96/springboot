package com.neusoft.springboot1.mapper;

import com.neusoft.springboot1.entity.Shopcar;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface ShopecarMapper {

    @Select("select s.s_id,s.u_id,s.status,s.addtime,s.updatetime,g.g_name,g.g_pic,g.g_price,s.number from shopcar s left join goods g on s.g_id=g.g_id")
//    @Select("select * from `order`")
    List<Shopcar> getAllShopcar();

    @Select("select s.s_id,s.status,s.addtime,s.updatetime,g.g_name,g.g_pic,g.g_price,s.number from shopcar s left join goods g on s.g_id=g.g_id where s.u_id=#{uId}")
//    @Select("select * from `order`")
    List<Shopcar> getShopcarById(Integer uId);

    @Update("update shopcar set status=#{status} where s_id =#{sId}")
    int updateShopcarStatus(@Param("status") Integer status, @Param("sId") Integer sId);
}
