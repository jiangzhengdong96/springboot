package com.neusoft.springboot1.mapper;

import com.neusoft.springboot1.entity.Shopcar;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface ShopecarMapper {

    @Select("select s.s_id,s.u_id,s.status,s.addtime,s.s_price,s.updatetime,g.g_name,g.g_pic,g.g_price,s.number from shopcar s left join goods g on s.g_id=g.g_id")
//    @Select("select * from `order`")
    List<Shopcar> getAllShopcar();

    @Select("select s.s_id,s.status,s.addtime,s.g_id,s.s_price,s.updatetime,g.g_name,g.is_delete,g.g_pic,g.g_price,s.number,g.up_status,g.g_status,g.g_num from shopcar s left join goods g on s.g_id=g.g_id where s.u_id=#{uId}")
//    @Select("select * from `order`")
    List<Shopcar> getShopcarById(Integer uId);

    @Select("select s.s_id,s.status,s.addtime,s.g_id,s.s_price,s.updatetime,g.g_name,g.g_pic,g.g_price,s.number,g.up_status,g.g_status,g.g_num from shopcar s left join goods g on s.g_id=g.g_id where s.s_id=#{sId}")
//    @Select("select * from `order`")
    Shopcar getShopcarBysId(Integer sId);
    @Select("select s.s_id,s.status,s.addtime,s.g_id,s.s_price,s.updatetime,g.g_name,g.g_pic,g.g_price,s.number,g.up_status,g.g_status,g.g_num from shopcar s left join goods g on s.g_id=g.g_id where s.g_id=#{gId} and s.u_id=#{uId}")
    Shopcar getShopcarBygIduId(@Param("gId") Integer gId,@Param("uId") Integer uId);

    @Update("update shopcar set status=#{status} where s_id =#{sId}")
    int updateShopcarStatus(@Param("status") Integer status, @Param("sId") Integer sId);

    @Update("update shopcar set number=#{number},s_price=#{sPrice} where s_id =#{sId}")
    int updateShopcarNumBysId(@Param("number") Integer number, @Param("sId") Integer sId,@Param("sPrice") float sPrice);

    @Update("update shopcar set number=#{number},s_price=#{sPrice} where g_id =#{gId} and u_id = #{uId}")
    int updateShopcarNumByuIdgId(@Param("number") Integer number, @Param("gId") Integer gId,@Param("sPrice") float sPrice, @Param("uId") Integer uId);

    @Delete("delete from shopcar where s_id=#{sId}")
    int deleteShopcarById(Integer sId);

    @Options(useGeneratedKeys = true,keyProperty = "sId")
    @Insert("insert into shopcar(g_id,u_id,addtime,updatetime,number,s_price) values(#{gId},#{uId},#{addtime},#{updatetime},#{number},#{sPrice})")
    int insertShopcar(Shopcar shopcar);
}
