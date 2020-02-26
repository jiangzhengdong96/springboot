package com.neusoft.springboot1.mapper;

import com.neusoft.springboot1.entity.OrderGoods;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface OrderGoodsMapper {

    @Select("select s.id,s.num,s.status,s.addtime,s.updatetime,g.g_name,g.g_price from order_goods s left join goods g on s.g_id=g.g_id where s.o_id=#{oId}")
//    @Select("select * from `order`")
    List<OrderGoods> getAllOrderGoodsById(Integer oId);

    @Update("update order_goods set status=#{status} where id =#{id}")
    int updateOrderGoodsStatus(@Param("status") Integer status, @Param("id") Integer id);
}
